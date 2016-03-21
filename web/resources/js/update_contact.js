(function($){
  $(document).on("ready", function() {
    $('form').on('submit', function(e){
      e.preventDefault();
      update_record($(this).serialize());
    });
  });

  var update_record = function(data){
    $(".form-group").removeClass('has-error');
    $(".help-block").remove();
    $.ajax({
      url: "/contacts/update",
      type: "POST",
      data: data,
      success: function(res){
        if (res.result == true){
          alert('Successfully update');
          window.location.href = "/contacts/";
        } else {
          var error_fields = Object.keys(res.errors);
          $.each(error_fields, function(index, value){
            input_field = $("input[name="+ value +"]");
            input_field.closest(".form-group").addClass('has-error');
            input_field.closest(".input-group").after('<p class="help-block" >' + res.errors[value]+ '</p>');
          });
        }
      }
    });
  };
})(jQuery);