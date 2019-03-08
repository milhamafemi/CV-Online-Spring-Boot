//search data in table
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblData tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

//configuration datatable
$(function () {
    $('#example').DataTable({
        'columnDefs': [{
            }
        ],
        'paging': true,
        'lengthChange': true,
        'searching': true,
        
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search..."
        },
        'info': true,
        'autoWidth': false
    })
}
)




