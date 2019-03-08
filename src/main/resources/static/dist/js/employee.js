
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
                "targets": [14]
            }, {
                "orderable": false,
                "visible": false,
                "targets": [12, 13]
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
        var syear, smonth, sday, eyear, emonth, eday, byear, bmonth, bday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        var births = new Date($row.find('td:eq(9)').text()),
                byear = '' + (births.getFullYear());
        if (births.getMonth() < 10) {
            bmonth = '0' + (births.getMonth() + 1);
        } else {
            bmonth = '' + (births.getMonth() + 1);
        }
        if (births.getDate() < 10) {
            bday = '0' + (births.getDate());
        } else {
            bday = '' + (births.getDate());
        }
        var starts = new Date($row.find('td:eq(10)').text()),
                syear = '' + (starts.getFullYear());
        if (starts.getMonth() < 10) {
            smonth = '0' + (starts.getMonth() + 1);
        } else {
            smonth = '' + (starts.getMonth() + 1);
        }
        if (starts.getDate() < 10) {
            sday = '0' + (starts.getDate());
        } else {
            sday = '' + (starts.getDate());
        }
        var ends = new Date($row.find('td:eq(11)').text()),
                eyear = '' + (ends.getFullYear());
        if (ends.getMonth() < 10) {
            emonth = '0' + (ends.getMonth() + 1);
        } else {
            emonth = '' + (ends.getMonth() + 1);
        }
        if (ends.getDate() < 10) {
            eday = '0' + (ends.getDate());
        } else {
            eday = '' + (ends.getDate());
        }
        document.getElementById('getIdEmployee').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameEmployee').value = $row.find('td:eq(2)').text();
        document.getElementById('getEmailEmployee').value = $row.find('td:eq(3)').text();
        document.getElementById('getPhone').value = $row.find('td:eq(4)').text();
        document.getElementById('getGender').value = $row.find('td:eq(5)').text();
        document.getElementById('getReligion').value = $row.find('td:eq(6)').text();
        document.getElementById('getMarital').value = $row.find('td:eq(7)').text();
        document.getElementById('getNationality').value = $row.find('td:eq(8)').text();
        document.getElementById('getBirth').value = [byear, bmonth, bday].join('-');
        document.getElementById('getStart').value = [syear, smonth, sday].join('-');
        document.getElementById('getEnd').value = [eyear, emonth, eday].join('-');
        var pw = $('#example').dataTable().fnGetData($row)[12],
                role = $('#example').dataTable().fnGetData($row)[13];
        document.getElementById('getPasswordEmployee').value = pw;
        document.getElementById('getRole').value = role;
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
                    url: "employee/delete/" + id
                });
//                window.location="/project/delete/" + id;
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});