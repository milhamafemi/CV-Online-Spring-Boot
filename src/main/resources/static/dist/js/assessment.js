/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
                "targets": [1]
            }, {
                "visible": false,
                "targets": [7, 8]
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
        document.getElementById('getNameProject').value = $row.find('td:eq(1)').text();
        document.getElementById('getStart').value = [syear, smonth, sday].join('-');
        document.getElementById('getEnd').value = [eyear, emonth, eday].join('-');
        document.getElementById('getAssess').value = $row.find('td:eq(4)').text();
        document.getElementById('getSpec').value = $row.find('td:eq(5)').text();
        document.getElementById('getStts').value = $row.find('td:eq(6)').text();
                var client = $('#example').dataTable().fnGetData($row)[7],
                id = $('#example').dataTable().fnGetData($row)[8];
        document.getElementById('getCl').value = client;
        document.getElementById('getIdProject').value = id;
    });
});
