//search 
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblData tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#example').DataTable({
        'columnDefs': [{
                targets: [ 6,8 ],
                visible: false,
                searchable: false
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

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $(".btnEdit").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements
        
        $("#id").val($row.find('td:eq(1)').text());
        var starts = new Date($row.find('td:eq(2)').text()),
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
        var ends = new Date($row.find('td:eq(3)').text()),
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
        document.getElementById('getIdProjectEmployee').value = $row.find('td:eq(1)').text();
        document.getElementById('getDesc').value = $row.find('td:eq(4)').text();
        document.getElementById('getStart').value = [syear, smonth, sday].join('-');
        document.getElementById('getEnd').value = [eyear, emonth, eday].join('-');
        document.getElementById('getStts').value = $row.find('td:eq(5)').text();
        var emp = $('#example').dataTable().fnGetData($row)[6],
        project = $('#example').dataTable().fnGetData($row)[8];
        document.getElementById('getEmp').value = emp;
        document.getElementById('getProject').value = project;
    });
});

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
                $.ajax ({
                    type: 'POST',
                    url: "projectemp/delete/"+id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});


