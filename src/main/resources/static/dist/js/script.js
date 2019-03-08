//            search 
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblData tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#example').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [{orderable: false, targets: [4]},
        ],
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search..."
        },
        'info': true,
        'autoWidth': false
    })
}
)




