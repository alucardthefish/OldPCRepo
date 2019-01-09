$(function()
{
  // Hide focus rectangles by default
  $('a').attr('hideFocus', 'true');
  // Show focus rectangles if the keyboard is used for navigation
  $(document).keydown(
    function()
    {
      $('a').removeAttr('hideFocus');
    }
  );
  // Hide them again as soon as the mouse is used
  $(document).mousedown(
    function()
    {
      $('a').attr('hideFocus', 'true');
    }
  );
  // Disable dragging entirely
  $(document.body).bind('dragstart', 
    function(event)
    {
      event.preventDefault();
    }
  );
  $(document).bind('selectstart',
    function()
    {
      return false;
    }
  );
});