/*
  ==============================================================================
    jQuery LayerButton plugin            Copyright (C) 2007 by Tibor Schiemann
  ==============================================================================
  
  USAGE EXAMPLE
  -------------

  $('.taskdlg-button').LayerButton(
    {
      'hover':
      {
        'imageSource':  { 'prefix': 'taskdlg_button_', 'suffix': '.png' },
        'imageBorders': { 'top': 3, 'right': 3, 'bottom': 3, 'left': 3 },
        'fadeIn':       { 'speed': 50,  'easing': 'easeOutQuad' },
        'fadeOut':      { 'speed': 150, 'easing': 'easeOutQuad' }
      }
    }
  );
*/

(function($)
{
  // Create our own namespace inside the jQuery namespace
  $.LayerButton = {};
  $.extend($.LayerButton, {
    // Internal unique IDs to identify groups and buttons
    runningGroupID:  0,
    runningButtonID: 0,
    // Automatically initializes some internal functionality on first use
    initialize: function()
    {
      if ($.LayerButton.initialized) return;
      $.LayerButton.initialized = true;
      window.setInterval(
        function()
        {
          // Remove unused hidden layers after a while
          var curTime = (new Date()).getTime();
          $('.lb-layer').each(
            function()
            {
              if (this.hiddenSince)
              {
                if (curTime - this.hiddenSince >= 30000)
                {
                  $(this).remove();
                }
              }
            }
          );
        },
        1000
      );
    },
    getLayerID: function(aParent, aType)
    {
      if (aType == 'hover')
      {
        return 'lblayer' + aParent.LayerButton.uniqueGroupID + aType;
      }
      else
      {
        return 'lblayer' + aParent.LayerButton.uniqueButtonID + aType;
      }
    },
    // Creates a layer on the fly and inserts it into the DOM before aParent
    createLayer: function(aParent, aType)
    {
      $.LayerButton.initialize();
      var html_contents =
        '<table id="' + $.LayerButton.getLayerID(aParent, aType) + '" lbgroupid="' + aParent.LayerButton.uniqueGroupID + '" lbbuttonid="' + aParent.LayerButton.uniqueButtonID + '" class="lb-layer ' + aType + '" style="width: 10px; height: 10px; position: absolute; z-index: -1; table-layout: fixed; border-collapse: collapse; filter: alpha(opacity=0)">' +
          '<col style="width: ' + aParent.LayerButton[aType].imageBorders.left + 'px"><col style="width: auto"><col style="width: ' + aParent.LayerButton[aType].imageBorders.right + 'px">' +
          '<tr style="height: ' + aParent.LayerButton[aType].imageBorders.top + 'px;">' +
            '<<tl>><<tm>><<tr>>' +
          '</tr>' +
          '<tr style="height: 100%">' +
            '<<ml>><<mm>><<mr>>' +
          '</tr>' +
          '<tr style="height: ' + aParent.LayerButton[aType].imageBorders.bottom + 'px;">' +
            '<<bl>><<bm>><<br>>' +
          '</tr>' +
        '</table>';
      html_contents = html_contents.replace(/<<(\w+)>>/g, '<td style="padding: 0px; filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=scale,src=\'' + /*<<'#AbsoluteBaseURL#' +*/ /*>>*/ aParent.LayerButton[aType].imageSource.prefix + '$1' + aParent.LayerButton[aType].imageSource.suffix + '\');"></td>');
      $('body').append(html_contents);
    },
    assignHoverLayer: function(aParent)
    {
      // Bind events
      $(aParent).hover(
        // Over
        function()
        {
          // Only show the hover layer when no selected layer is visible
          var selectedLayer = $.LayerButton.findLayer(aParent, 'selected', false);
          if (selectedLayer.length && selectedLayer[0].visible) return;
          // Resize the hover element to fit the button size
          $.LayerButton.updateLayerDimensions(aParent, 'hover');
          // Fade in
          $.LayerButton.showLayer(aParent, 'hover');
        },
        // Out
        function()
        {
          // Fade out
          $.LayerButton.hideLayer(aParent, 'hover');
        }
      );
    },
    assignSelectedLayer: function(aParent)
    {
      // Bind events
      $(aParent).click(
        function()
        {
          $(aParent).LayerButton_Select(false);
        }
      );
    },
    findLayer: function(aParent, aType, aAutoCreate)
    {
      // Try to find the layer
      var layerID = $.LayerButton.getLayerID(aParent, aType);
      var layer   = $('#' + layerID);
      // If the layer does not exist, create it on the fly
      if (!layer.length && aAutoCreate)
      {
        $.LayerButton.createLayer(aParent, aType);
        layer = $('#' + layerID);
      }
      return layer;
    },
    updateLayerDimensions: function(aParent, aType)
    {
      var layer = $.LayerButton.findLayer(aParent, aType, true);
      if (!layer.length) return;
      
      // Calculate new rectangle
      var new_pos  = $(aParent).offset({ scroll: false });
      var new_size = {
        'width':      $(aParent).innerWidth(),
        'height':     $(aParent).innerHeight()
      };
      // Calculate current rectangle
      var old_pos  = layer.offset({ scroll: false });
      var old_size = {
        'left':       layer.left,
        'top':        layer.top,
        'width':      layer.innerWidth(),
        'height':     layer.innerHeight()
      };
      
      // Update CSS properties of the hover element if necessary
      if (
           (new_pos.left    != old_pos.left) ||
           (new_pos.top     != old_pos.top) ||
           (new_size.width  != old_size.width) ||
           (new_size.height != old_size.height)
         )
      {
        // Store the previous opacity value
        var oldOpacity = layer.css('opacity');
        // Set the opacity to 0 to make the layer invisible, move it to its new
        // location and resize it to fit the parent LayerButton
        layer.css(
          {
            'opacity':    0,
            'left':       new_pos.left,
            'top':        new_pos.top,
            'width':      new_size.width,
            'height':     new_size.height - aParent.LayerButton[aType].imageBorders.top - aParent.LayerButton[aType].imageBorders.bottom
          }
        );
        // Restore the opacity back to its previous value
        layer.css(
          {
            'opacity':    oldOpacity
          }
        );
      }
    },
    resetLayer: function(aParent, aType)
    {
      var layer = $.LayerButton.findLayer(aParent, aType, false);
      if (!layer.length) return;
      
      layer.css(
        {
          'width':  '10px',
          'height': '10px'
        }
      );
    },
    showLayer: function(aParent, aType)
    {
      var layer = $.LayerButton.findLayer(aParent, aType, true);
      if (!layer.length) return;
      
      $.LayerButton._showLayer(
        layer,
        aParent.LayerButton[aType].fadeIn,
        aParent.LayerButton[aType].maxOpacity
      );
    },
    hideLayer: function(aParent, aType)
    {
      var layer = $.LayerButton.findLayer(aParent, aType, false);
      if (!layer.length) return;
      
      $.LayerButton._hideLayer(layer, aParent.LayerButton[aType].fadeOut);
    },
    _showLayer: function(aLayer, aAnimation, aMaxOpacity)
    {
      aLayer
        .queue('fx', [])
        .stop();
      aLayer[0].visible     = true;
      aLayer[0].hiddenSince = 0;
      
      if (aAnimation)
      {
        aLayer
          .animate(
            {
              opacity: (aMaxOpacity ? aMaxOpacity : 0.99)
            },
            aAnimation.speed,
            aAnimation.easing
          );
      }
      else
      {
        aLayer.css(
          {
            opacity: (aMaxOpacity ? aMaxOpacity : 0.99)
          }
        );
      }
    },
    _hideLayer: function(aLayer, aAnimation)
    {
      aLayer
        .queue('fx', [])
        .stop();
      aLayer[0].visible = false;
      
      if (aAnimation)
      {
        aLayer
          .animate(
            {
              opacity: 0
            },
            aAnimation.speed,
            aAnimation.easing
          )
          .queue(
            function()
            {
              aLayer[0].hiddenSince = (new Date()).getTime();
              $(aLayer).dequeue();
            }
          );
      }
      else
      {
        aLayer.css(
          {
            opacity: 0
          }
        );
        aLayer[0].hiddenSince = (new Date()).getTime();
      }
    },
    swapVisibleLayer: function(aParent, aHideLayerType, aShowLayerType, aBypassFadeIn)
    {
      var layerToHide = $.LayerButton.findLayer(aParent, aHideLayerType, false);
      var layerToShow = $.LayerButton.findLayer(aParent, aShowLayerType, true);
      if (layerToShow.length)
      {
        $.LayerButton._showLayer(
          layerToShow,
          aBypassFadeIn ? 0 : aParent.LayerButton[aShowLayerType].fadeIn,
          aParent.LayerButton[aShowLayerType].maxOpacity
        );
      }
      if (layerToHide.length)
      {
        $.LayerButton._hideLayer(
          layerToHide,
          aBypassFadeIn ? 0 : aParent.LayerButton[aShowLayerType].fadeIn
        );
      }
    }
  });
  
  // Add new public functionality to all jQuery objects
  $.fn.extend(
    {
      LayerButton: function(aAttributes)
      {
        // Assign one unique group class ID to the whole group of
        // selected elements
        var uniqueGroupID = '';
        if (aAttributes.groupID)
        {
          uniqueGroupID = aAttributes.groupID;
        }
        else
        {
          $.LayerButton.runningGroupID = $.LayerButton.runningGroupID + 1;
          uniqueGroupID = $.LayerButton.runningGroupID;
        }
        // Initialize LayerButton functionality for each of the
        // selected elements one by one
        return this.each(
          function()
          {
            // Save the given LayerButton attributes in the DOM node
            // so that they can be accessed later
            this.LayerButton = {};
            $.extend(this.LayerButton, aAttributes);
            // Create a unique button class ID
            $.LayerButton.runningButtonID = $.LayerButton.runningButtonID + 1;
            $.extend(this.LayerButton, {
              'uniqueGroupID':  uniqueGroupID,
              'uniqueButtonID': $.LayerButton.runningButtonID
            });
            $(this)
              .addClass('lb-button')
              .attr('lbgroupid',  this.LayerButton.uniqueGroupID)
              .attr('lbbuttonid', this.LayerButton.uniqueButtonID);
            // Has a hover layer been specified?
            if (this.LayerButton.hover)
            {
              // Yes, bind events
              $.LayerButton.assignHoverLayer(this);
            }
            // Has a selected layer been specified?
            if (this.LayerButton.selected)
            {
              // Yes, bind events
              $.LayerButton.assignSelectedLayer(this);
            }
            // Do we need to listen to events?
            if (this.LayerButton.events)
            {
              // Handle click event
              if (this.LayerButton.events.click)
              {
                $(this).bind('click', this.LayerButton.events.click);
              }
            }
          }
        );
      },
      LayerButton_Select: function(aBypassFadeIn)
      {
        return this.each(
          function()
          {
            var clickedButtonID = $(this).attr('lbbuttonid');
            if (!clickedButtonID) return;
            
            // Resize the selected element to fit the button size
            $.LayerButton.updateLayerDimensions(this, 'selected');
            // Hide hover layer and show selected layer at the same time
            $.LayerButton.swapVisibleLayer(this, 'hover', 'selected', aBypassFadeIn);
            // Check if the clicked button belongs to a group
            var clickedGroupID = $(this).attr('lbgroupid');
            if (clickedGroupID)
            {
              // Find previously selected button(s) within the same group
              var previouslySelected = $('.lb-button[lbgroupid=' + clickedGroupID + '][lbbuttonid!=' + clickedButtonID + ']');
              // Hide selected layer of previously selected button (if any)
              if (previouslySelected.length)
              {
                previouslySelected.each(
                  function()
                  {
                    $.LayerButton.hideLayer(this, 'selected');
                  }
                );
              }
            }
          }
        );
      }
    }
  );

  /*
  $(window).resize(
    function()
    {
      // Hide all hover elements when the window is being resized
      $('.taskdlg-button-hover')
        .stop()
        .taskdlg_reset_hover();
    }
  );
  */
  
})(jQuery);