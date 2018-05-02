$(document).ready(function() {
  $('#button_get').click(function() {
    $.ajax({
      type:'GET',
      url : 'main',
      success : function(result) {
        $('#result').text(result.servletInnerState);
      }
    });
  });
  $('#button_post').click(function() {
    $.ajax({
      type:'POST',
      url : 'main',
      success : function(result) {
        $('#result').text(result.servletInnerState);
      }
    });
  });
  $('#button_put').click(function() {
    $.ajax({
      type:'PUT',
      url : 'main',
      success : function(result) {
        $('#result').text(result.servletInnerState);
      }
    });
  });
  $('#button_delete').click(function() {
    $.ajax({
      type:'DELETE',
      url : 'main',
      success : function(result) {
        $('#result').text(result.servletInnerState);
      }
    });
  });
});
