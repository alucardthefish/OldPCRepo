$(function()
{

/* ==================== Window caption and header buttons =================== */

  $('button')
    .attr('hideFocus', 'true')
    .mousedown(
      function(event)
      {
        if ((event.button & 1) != 1) return;
        
        $(this).addClass('down');
        if ($(this).is('.hover'))
        {
          $(this).addClass('hoverdown');
          updateButton(this, 'hoverdown');
        }
      }
    )
    .bind('losecapture', 
      function()
      {
        if ($(this).is('.locked')) return;
        $(this).removeClass('down hoverdown');
        if ($(this).is('.hover'))
        {
          updateButton(this, 'hover');
        }
      }
    )
    .hover(
      // Over
      function()
      {
        $(this).addClass('hover');
        if ($(this).is('.down'))
        {
          $(this).addClass('hoverdown');
          updateButton(this, 'hoverdown');
        }
        else
        {
          updateButton(this, 'hover');
        }
      },
      // Out
      function()
      {
        if ($(this).is('.locked')) return;
        $(this).removeClass('hover hoverdown');
        updateButton(this, '');
      }
    );
    
  $('#header .titlebar')
    .mousedown(
      function(event)
      {
        if ((event.button & 1) != 1) return;
        alert('#header:move');
      }
    )

  function updateButton(buttonToUpdate, newState)
  {
    if (buttonToUpdate.id && ((buttonToUpdate.id == 'nc-minimize') || (buttonToUpdate.id == 'nc-close')))
    {
      if (buttonToUpdate.id == 'nc-minimize')
      {
        var aThis = 'minimize';
        var aThat = 'close';
      }
      else
      {
        var aThis = 'close';
        var aThat = 'minimize';
      }
      if (newState == 'hoverdown')
      {
        $('#nc-buttons').addClass   ('hoverdown-' + aThis);
        $('#nc-buttons').removeClass('hoverdown-' + aThat);
      }
      else if (newState == 'hover')
      {
        $('#nc-buttons').addClass   ('hover-' + aThis);
        $('#nc-buttons').removeClass('hover-' + aThat);
        $('#nc-buttons').removeClass('hoverdown-minimize');
        $('#nc-buttons').removeClass('hoverdown-close');
      }
      else
      {
        $('#nc-buttons').removeClass('hover-'     + aThis);
        $('#nc-buttons').removeClass('hoverdown-' + aThis);
      }
    }
  }

  $('#nc-minimize').click(
    function()
    {
      alert('#header:minimize');
    }
  );
  $('#nc-close').click(
    function()
    {
      alert('#header:close');
    }
  );

  $('#subnav-rescuecenter').click(
    function()
    {
      alert('#launch:RescueCenter.exe');
    }
  );
  $('#subnav-updatewizard').click(
    function()
    {
      alert('#launch:UpdateWizard.exe');
    }
  );
  $('#subnav-settings').mousedown(
    function()
    {
      if ((event.button & 1) != 1) return;
      
      var elementPos    = $(this).offset({ scroll: false });
      elementPos.width  = $(this).width();
      elementPos.height = $(this).height();
      
      $(this).addClass('locked');
      alert('#header:popup_settings:' + elementPos.left + ':' + elementPos.top + ':' + elementPos.width + ':' + elementPos.height);
      $(this).removeClass('hover down hoverdown locked');
    }
  );
/*
*/

/* ============================= Category buttons =========================== */
  
  $('#categories .category').LayerButton(
    {
      'groupID':        'categories',
      'hover':
      {
        'imageSource':  { 'prefix': 'btn_hover_', 'suffix': '.png' },
        'imageBorders': { 'top': 12, 'right': 6, 'bottom': 6, 'left': 6 },
        'fadeIn':       { 'speed': 150, 'easing': 'easeOutQuad' },
        'fadeOut':      { 'speed': 150, 'easing': 'easeOutQuad' }
      },
      'selected':
      {
        'imageSource':  { 'prefix': 'btn_selected_', 'suffix': '.png' },
        'imageBorders': { 'top': 12, 'right': 6, 'bottom': 6, 'left': 6 },
        'fadeIn':       { 'speed': 300, 'easing': 'easeOutQuad' },
        'fadeOut':      { 'speed': 300, 'easing': 'easeOutQuad' }
      }
    }
  );
  $('#categories .category').click(handleCategoryClick);
  
  function handleCategoryClick(event)
  {
    selectCategory(this, false);
    event.preventDefault();
  }
  
  function selectCategory(aCategoryButton, aManual)
  {
    var newCategory = $(aCategoryButton).attr('id');
    if (!newCategory) return;
    newCategory = newCategory.substr(9);
    
    // If we've been called manually, make sure the LayerButton is selected
    if (aManual)
    {
      $(aCategoryButton).LayerButton_Select();
    }

    // Hide the old category and its associated page
    var oldCategory = $('#categories .category.active').attr('id');
    if (oldCategory)
    {
      oldCategory = oldCategory.substr(9);
      if (newCategory != oldCategory)
      {
        alert('#hidecategory:' + oldCategory);
      }
    }
    if (newCategory != oldCategory)
    {
      $('#categories .category.active').removeClass('active');
      $('#pages .page.active').removeClass('active');
    }
    
    // Show the new category and its associated page
    if (aManual || (newCategory != oldCategory))
    {
      alert('#showcategory:' + newCategory);
    }
    if (newCategory != oldCategory)
    {
      $('#category-' + newCategory).addClass('active');
      $('#page-'     + newCategory).addClass('active');
    }
  }

  selectCategory($('#categories .category.active'), true);

/* =========================== Normal task buttons ========================== */

  $('table.task-button td samp:not(:last-child)').append('<span class="separator"></span>');
  $('table.task-button img[@src$=.png]').ifixpng(48, 48);
  $('table.task-button').LayerButton(
    {
      'hover':
      {
        'imageSource':  { 'prefix': 'taskdlg_button_', 'suffix': '.png' },
        'imageBorders': { 'top': 3, 'right': 3, 'bottom': 3, 'left': 3 },
        'fadeIn':       { 'speed': 150, 'easing': 'easeOutQuad' },
        'fadeOut':      { 'speed': 250, 'easing': 'easeOutQuad' }
      }
    }
  );
  $('.task-button').click(handleTaskClick);
  
  function handleTaskClick(event)
  {
    // Get the target of the clicked task button (the link inside the h2 tag)
    var clickedElement = $(event.target);
    var headerElement  = clickedElement.parents('.task-button').find('h2 a');
    var taskTarget     = headerElement.attr('href');
    var taskCaption    = headerElement.text().replace(/&nbsp;/g, ' ');

    // If the user clicked directly on a link, check if a more specific target
    // has been specified there
    var specificTarget = clickedElement.attr('href');
    if (specificTarget)
    {
      if (
           (specificTarget.substr(0, 2) == '#') ||
           (specificTarget.substr(0, 2) == '#:')
         )
      {
        taskTarget = taskTarget + specificTarget.substr(1);
      }
      else
      {
        taskTarget = specificTarget;
      }
    }
    // Prefix launch parameters with the task caption
    if (taskTarget.substr(0, 8) == '#launch:')
    {
      taskTarget = '#launch: ' + escape(taskCaption) + ':' + taskTarget.substr(8);
    }
    
    // Send the task target link to the software
    alert(taskTarget);
    event.preventDefault();
  }

/* ========================== Cleanup task buttons ========================== */

  $('table.cleanup-button img[@src$=.png]').ifixpng(48, 48);
  $('table.cleanup-button').LayerButton(
    {
      'hover':
      {
        'imageSource':  { 'prefix': 'taskdlg_button_', 'suffix': '.png' },
        'imageBorders': { 'top': 3, 'right': 3, 'bottom': 3, 'left': 3 },
        'fadeIn':       { 'speed': 150, 'easing': 'easeOutQuad' },
        'fadeOut':      { 'speed': 250, 'easing': 'easeOutQuad' }
      }
    }
  );
  $('table.cleanup-button').click(handleCleanupClick);
  
  function handleCleanupClick(event)
  {
    // Get the target of the clicked task button (the link inside the h2 tag)
    var clickedElement = $(event.target);
    var taskTarget     = clickedElement.parents('.cleanup-button').find('h2 a').attr('href');
    
    // Send the task target link to the software
    alert(taskTarget);
    event.preventDefault();
  }

/* ============================ "See also" links ============================ */

  $('table.see-also img[@src$=.png]').ifixpng(16, 16);
  $('table.see-also a').click(handleSeeAlsoClick);
  
  function handleSeeAlsoClick(event)
  {
    // Get the target of the clicked link
    var clickedElement = $(event.target);
    var taskTarget     = clickedElement.attr('href');
    var taskCaption    = clickedElement.text().replace(/&nbsp;/g, ' ');
    
    // Prefix launch parameters with the task caption
    if (taskTarget.substr(0, 8) == '#launch:')
    {
      taskTarget = '#launch: ' + escape(taskCaption) + ':' + taskTarget.substr(8);
    }
    
    // Send the task target link to the software
    alert(taskTarget);
    event.preventDefault();
  }

/* =============================== Other stuff ============================== */

  $('#page-maintain table.tasks .status img').ifixpng(12, 12);
  $('#beta img').ifixpng(92, 56);

});