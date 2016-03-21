(function($){
  $(document).on("ready", function() {
    $("tr").on("click", "#delete", function(){
      var row = $(this).closest('tr');
      delete_record(row);
    });
  });

  var delete_record = function(row){
    var warning = $(".alert-warning")
    var success = $(".alert-success")
    $.ajax({
      url: "/contacts/delete",
      type: "GET",
      data: { "id": row.find('td:first').text()},
      success: function(res){
        if (res.result == true){
          row.remove();
          alert("Successfully delete this record!");
        } else {
          alert("An error occur. Please try again later!");
        }
      }
    });
  };
})(jQuery);