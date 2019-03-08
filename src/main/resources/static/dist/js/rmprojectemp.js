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
                "targets": [ 1,7,9 ],
                "visible": false
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
        var starts = new Date($row.find('td:eq(3)').text());
                syear = '' + (starts.getFullYear());
        if (starts.getMonth() < 10) {
            smonth = '0' + (starts.getMonth() + 1),
                    sday = '0' + (starts.getDate());
        } else {
            smonth = '' + (starts.getMonth() + 1),
                    sday = '' + (starts.getDate());
        }
        var ends = new Date($row.find('td:eq(4)').text());
                eyear = '' + (starts.getFullYear());
        if (starts.getMonth() < 10) {
            emonth = '0' + (starts.getMonth() + 1),
                    eday = '0' + (starts.getDate());
        } else {
            emonth = '' + (starts.getMonth() + 1),
                    eday = '' + (starts.getDate());
        }
        document.getElementById('getIdProjectEmployee').value = $row.find('td:eq(1)').text();
        document.getElementById('getDesc').value = $row.find('td:eq(5)').text();
        document.getElementById('getStart').value = [syear, smonth, sday].join('-');
        document.getElementById('getEnd').value = [eyear, emonth, eday].join('-');
        document.getElementById('getStts').value = $row.find('td:eq(6)').text();
        var emp = $('#example').dataTable().fnGetData($row)[7],
        project = $('#example').dataTable().fnGetData($row)[9];
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
                    url: "/rmhome/rmproject/delete/"+id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});


$(function () {
    $(".btnAdd").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idProjectEmployee').value = id;
    });
});

$(function () {
    $(".btnEmp").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements
        
        $("#id").val($('#example').dataTable().fnGetData($row)[1]);
        document.getElementById('getIdProjectEmp').value = $('#example').dataTable().fnGetData($row)[1];
        document.getElementById('getProjDesc').value = $row.find('td:eq(4)').text();
        document.getElementById('getProjStts').value = $row.find('td:eq(5)').text();
        document.getElementById('getProjectId').value = $('#example').dataTable().fnGetData($row)[9];
    });
});