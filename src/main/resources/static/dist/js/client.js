
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
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [7]
            }
            , {
                "visible": false,
                "targets": [6]
            }
        ],
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search..."
        },
        'info': true,
        'autoWidth': false
    });
});

//get data from table for modal edit
$(function () {
    $(".btnEdit").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getIdClient').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameClient').value = $row.find('td:eq(2)').text();
        document.getElementById('getEmailClient').value = $row.find('td:eq(3)').text();
        document.getElementById('getAddress').value = $row.find('td:eq(4)').text();
        document.getElementById('getBusiness').value = $row.find('td:eq(5)').text();
                var pw = $('#example').dataTable().fnGetData($row)[6];
        document.getElementById('getPasswordClient').value = pw;

    });
});

//delete data with sweet alert
$(function () {
    var table = $('#example').DataTable();

    $('#example tbody').on('click', '.btnDelete', function () {
        var btn = $(this), id = btn.data('id');
        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this imaginary file!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: 'btn-danger',
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: "No, cancel plx!",
            closeOnConfirm: false,
            closeOnCancel: false
        }, function (isConfirm) {
            if (isConfirm) {
                swal("Deleted!", "Your imaginary file has been deleted!", "success");
                table.row($(btn).parents('tr')).remove().draw(false);
                $.ajax({
                    type: 'POST',
                    url: "client/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});