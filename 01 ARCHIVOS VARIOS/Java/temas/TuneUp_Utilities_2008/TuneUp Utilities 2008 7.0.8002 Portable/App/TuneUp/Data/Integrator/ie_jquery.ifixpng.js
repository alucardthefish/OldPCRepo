/*
 * jQuery ifixpng plugin
 * renamed from pngfix to ifixpng due to naming conflict 
 * with another plugin
 * Version 1.7  (18/09/2007)
 * @requires jQuery v1.1.3 or above
 *
 * Examples at: http://jquery.khurshid.com
 * Copyright (c) 2007 Kush M.
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 */
 
 /**
  *
  * @example
  *
  * optional if location of pixel.gif if different to default which is images/pixel.gif
  * $.ifixpng('media/pixel.gif');
  *
  * $('img[@src$=.png], #panel').ifixpng();
  *
  * @apply hack to all png images and #panel which icluded png img in its css
  *
  * @name ifixpng
  * @type jQuery
  * @cat Plugins/Image
  * @return jQuery
  * @author jQuery Community
  */
 
(function($) {
	
	/**
	 * helper variables and function
	 */
	$.ifixpng = function(customPixel) {
		$.ifixpng.pixel = customPixel;
	};
	
	$.ifixpng.getPixel = function() {
		return $.ifixpng.pixel || /*<<'#AbsoluteBaseURL#' +*/ /*>>*/ 'empty.gif';
	};

	var needfix = $.browser.msie;
  /*@cc_on
     @if (@_jscript_version >= 5.7)
       needfix = false;
     @end
  @*/
	var hack = {
		ltie7  : needfix,
		filter : function(src, scale) {
		  if (scale)
			{
			  var sizingMethod='scale';
			}
		  else
			{
			  var sizingMethod='crop';
			}
			return "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=" + sizingMethod + ",src='" + src + "')";
		}
	};
	
	/**
	 * Applies ie png hack to selected dom elements
	 *
	 * $('img[@src$=.png]').ifixpng();
	 * @desc apply hack to all images with png extensions
	 *
	 * $('#panel, img[@src$=.png]').ifixpng();
	 * @desc apply hack to element #panel and all images with png extensions
	 *
	 * @name ifixpng
	 */
	 
	$.fn.ifixpng = hack.ltie7 ? function(defaultWidth, defaultHeight, scale) {
    	var defaultWidth  = (defaultWidth  == null) ? 32    : defaultWidth;
    	var defaultHeight = (defaultHeight == null) ? 32    : defaultHeight;
    	var scale         = (scale         == null) ? false : scale;
    	return this.each(function() {
			var $$ = $(this);
			var base = $('base').attr('href'); // need to use this in case you are using rewriting urls
			if ($$.is('img') || $$.is('input')) { // hack image tags present in dom
				if ($$.attr('src').match(/.*\.png([?].*)?$/i)) { // make sure it is png image
					// use source tag value if set 
					var source = (base && $$.attr('src').substring(0,1)!='/') ? base + $$.attr('src') : /*<<'#AbsoluteBaseURL#' +*/ /*>>*/ $$.attr('src');
					// apply filter
					var imgWidth  = $$.attr('width')  || defaultWidth;
					var imgHeight = $$.attr('height') || defaultHeight;
					$$.css({filter:hack.filter(source, scale), width:imgWidth, height:imgHeight})
					  .attr({src:$.ifixpng.getPixel()})
					  .positionFix();
				}
			} else { // hack png css properties present inside css
				var image = $$.css('backgroundImage');
				if (image.match(/^url\(["']?(.*\.png([?].*)?)["']?\)$/i)) {
					image = RegExp.$1;
					$$.css({backgroundImage:'none', filter:hack.filter(image, scale)})
					  .positionFix();
				}
			}
		});
	} : function() { return this; };
	
	/**
	 * Removes any png hack that may have been applied previously
	 *
	 * $('img[@src$=.png]').iunfixpng();
	 * @desc revert hack on all images with png extensions
	 *
	 * $('#panel, img[@src$=.png]').iunfixpng();
	 * @desc revert hack on element #panel and all images with png extensions
	 *
	 * @name iunfixpng
	 */
	 
	$.fn.iunfixpng = hack.ltie7 ? function() {
    	return this.each(function() {
			var $$ = $(this);
			var src = $$.css('filter');
			if (src.match(/src=["']?(.*\.png([?].*)?)["']?/i)) { // get img source from filter
				src = RegExp.$1;
				if ($$.is('img') || $$.is('input')) {
					$$.attr({src:src}).css({filter:''});
				} else {
					$$.css({filter:'', background:'url('+src+')'});
				}
			}
		});
	} : function() { return this; };
	
	/**
	 * positions selected item relatively
	 */
	 
	$.fn.positionFix = function() {
		return this.each(function() {
			var $$ = $(this);
			var position = $$.css('position');
			if (position != 'absolute' && position != 'relative') {
				$$.css({position:'relative'});
			}
		});
	};

})(jQuery);