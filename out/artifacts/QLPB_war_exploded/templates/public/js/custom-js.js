$(document).ready(function() {
    setTimeout(function() {
        $('.notification').remove();
    }, 3000);

    $('.js-search').on('keyup', function() {
        let keyWord = $(this).val();
        $.ajax({
            url: $('#url').val(),
            method: 'get',
            data: { key: keyWord },
            success: function(data) {
                console.log(data);
                $('.x_content').html(data);
            }
        })
    })
});




