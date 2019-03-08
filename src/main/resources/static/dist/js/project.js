/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $(".btnEdit").click(function () {
        var syear, smonth, sday, eyear, emonth, eday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        var starts = new Date($row.find('td:eq(3)').text()),
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
        var ends = new Date($row.find('td:eq(4)').text()),
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
        document.getElementById('getIdProject').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameProject').value = $row.find('td:eq(2)').text();
        document.getElementById('getStart').value = [syear, sday, smonth].join('-');
        document.getElementById('getEnd').value = [eyear, eday, emonth].join('-');
//                    document.getElementById('getAssess').value = $row.find('td:eq(5)').text();
        document.getElementById('getSpec').value = $row.find('td:eq(6)').text();
        document.getElementById('getStts').value = $row.find('td:eq(7)').text();
        document.getElementById('getCl').value = $row.find('td:eq(8)').text();
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
                    url: "project/delete/"+id
                });
//                window.location="/project/delete/" + id;
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});