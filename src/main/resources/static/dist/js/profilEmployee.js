

$(function () {
    $(".btnEditProfil").click(function () {
//        var syear, smonth, sday, eyear, emonth, eday, byear, bmonth, bday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(0)').text());
        var births = new Date($row.find('td:eq(8)').text()),
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
        var starts = new Date($row.find('td:eq(9)').text()),
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
        var ends = new Date($row.find('td:eq(10)').text()),
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
        document.getElementById('getIdEmployee').value = $row.find('td:eq(0)').text();
        console.log($row.find('td:eq(1)').text());
        document.getElementById('getNameEmployee').value = $row.find('td:eq(1)').text();
        document.getElementById('getEmailEmployee').value = $row.find('td:eq(2)').text();
        document.getElementById('getPhone').value = $row.find('td:eq(3)').text();
        document.getElementById('getGender').value = $row.find('td:eq(4)').text();
        document.getElementById('getReligion').value = $row.find('td:eq(5)').text();
        document.getElementById('getMarital').value = $row.find('td:eq(6)').text();
        document.getElementById('getNationality').value = $row.find('td:eq(7)').text();
        document.getElementById('getBirth').value = [byear, bmonth, bday].join('-');
        document.getElementById('getStart').value = [syear, smonth, sday].join('-');
        document.getElementById('getEnd').value = [eyear, emonth, eday].join('-');
//        var pw = $('#example').dataTable().fnGetData($coloumn)[11],
//                role = $('#example').dataTable().fnGetData($coloumn)[12];
        document.getElementById('getPasswordEmployee').value = $row.find('td:eq(11)').text();
        document.getElementById('getRole').value = $row.find('td:eq(12)').text();

    });


});



$(function () {
    $(".btnChangePassword").click(function () {
//        var syear, smonth, sday, eyear, emonth, eday, byear, bmonth, bday;
       var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(0)').text());

        document.getElementById('getIdChangePassword').value = $row.find('td:eq(0)').text();
        console.log($row.find('td:eq(4)').text());
        document.getElementById('getNameChangePassword').value = $row.find('td:eq(1)').text();
        document.getElementById('getEmailChangePassword').value = $row.find('td:eq(2)').text();
        document.getElementById('getRoleChangePassword').value = $row.find('td:eq(3)').text();
        document.getElementById('getPasswordChangePassword').value = $row.find('td:eq(4)').text();
    });


});


//script achievement
$(function () {
    $('#exampleAchievement').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {"orderable": false,
                "targets": [0, 1, 2, 4]
            },
            {
                "visible": false,
                "targets": [3]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddAchievement").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idachievement').value = id;
    });
});

$(function () {
    $(".btnEditAchievement").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getNameAchievement').value = $row.find('td:eq(1)').text();
        document.getElementById('getDescriptionAchievement').value = $row.find('td:eq(2)').text();
        var id = $('#exampleAchievement').dataTable().fnGetData($row)[3];
        document.getElementById('getIdAchievement').value = id;

    });
});

$(function () {
    var table = $('#exampleAchievement').DataTable();

    $('#exampleAchievement tbody').on('click', '.btnDeleteAchievement', function () {
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
                    url: "achievement/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script achievement

//scrip certification
$(function () {
    $('#exampleCertification').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [{"orderable": false,
                "targets": [0, 1, 2, 3, 5]},
            {
                "visible": false,
                "targets": [4]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddCertification").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idcertification').value = id;
    });
});

$(function () {
    $(".btnEditCertification").click(function () {
//        var exyear, exmonth, exday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        var id = $('#exampleCertification').dataTable().fnGetData($row)[4];
//        $("#id").val($row.find('td:eq(1)').text());

        var exp = new Date($row.find('td:eq(2)').text()),
                exyear = '' + (exp.getFullYear());
        if (exp.getMonth() < 10) {
            exmonth = '0' + (exp.getMonth() + 1);
        } else {
            exmonth = '' + (exp.getMonth() + 1);
        }
        if (exp.getDate() < 10) {
            exday = '0' + (exp.getDate());
        } else {
            exday = '' + (exp.getDate());
        }
        document.getElementById('getNameCertification').value = $row.find('td:eq(1)').text();
        document.getElementById('getExpiredDate').value = [exyear, exmonth, exday].join('-');
        document.getElementById('getDescriptionCertification').value = $row.find('td:eq(3)').text();

        document.getElementById('getIdCertification').value = id;

    });
});

$(function () {
    var table = $('#exampleCertification').DataTable();

    $('#exampleCertification tbody').on('click', '.btnDeleteCertification', function () {
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
                    url: "certification/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script certification

//script education
$(function () {
    $('#exampleEducation').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 3, 4, 5, 8]
            }, {
                "visible": false,
                "targets": [6, 7]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddEducation").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('ideducation').value = id;
    });
});

$(function () {
    $(".btnEditEducation").click(function () {
//        var exyear, exmonth, exday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());

        var starts = new Date($row.find('td:eq(1)').text()),
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
        var ends = new Date($row.find('td:eq(2)').text()),
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
        document.getElementById('getStartMU').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndMU').value = [eyear, emonth, eday].join('-');
        document.getElementById('getIP').value = $row.find('td:eq(3)').text();
        var mu = $('#exampleEducation').dataTable().fnGetData($row)[6];
        document.getElementById('getMajorUniversity').value = mu;
        var id = $('#exampleEducation').dataTable().fnGetData($row)[7];
        document.getElementById('getIdEducation').value = id;

    });
});

$(function () {
    var table = $('#exampleEducation').DataTable();

    $('#exampleEducation tbody').on('click', '.btnDeleteEducation', function () {
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
                    url: "education/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script education

//script experience

$(function () {
    $('#exampleExperience').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 4]
            }, {
                "visible": false,
                "targets": [3]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddExperience").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idexperience').value = id;
    });
});

$(function () {
    $(".btnEditExperience").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getNameExperience').value = $row.find('td:eq(1)').text();
        document.getElementById('getDescriptionExperience').value = $row.find('td:eq(2)').text();
        var id = $('#exampleExperience').dataTable().fnGetData($row)[3];
        document.getElementById('getIdExperience').value = id;

    });
});

$(function () {
    var table = $('#exampleExperience').DataTable();

    $('#exampleExperience tbody').on('click', '.btnDeleteExperience', function () {
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
                    url: "experience/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script experience

//script language employee

$(function () {
    $('#exampleLanguageEmployee').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 4]
            },
            {
                "visible": false,
                "targets": [2, 3]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddLanguageEmployee").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idlanguageemployee').value = id;
    });
});

$(function () {
    $(".btnEditLanguageEmployee").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        var fla = $('#exampleLanguageEmployee').dataTable().fnGetData($row)[2];
        document.getElementById('getForeignLanguage').value = fla;
        var id = $('#exampleLanguageEmployee').dataTable().fnGetData($row)[3];
        document.getElementById('getIdLanguage').value = id;

    });
});

$(function () {
    var table = $('#exampleLanguageEmployee').DataTable();

    $('#exampleLanguageEmployee tbody').on('click', '.btnDeleteLanguageEmployee', function () {
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
                    url: "languageEmployee/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script language employee

//script organization

$(function () {
    $('#exampleOrganization').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 3, 4, 6]
            },
            {
                "visible": false,
                "targets": [5]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddOrganization").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idorganization').value = id;
    });
});

$(function () {
    $(".btnEditOrganization").click(function () {
//        var exyear, exmonth, exday;
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
        document.getElementById('getNameOrganization').value = $row.find('td:eq(1)').text();
        document.getElementById('getPositionOrganization').value = $row.find('td:eq(2)').text();
        document.getElementById('getStartDateOrganization').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndDateOrganization').value = [eyear, emonth, eday].join('-');
        var id = $('#exampleOrganization').dataTable().fnGetData($row)[5];
        document.getElementById('getIdOrganization').value = id;

    });
});

$(function () {
    var table = $('#exampleOrganization').DataTable();

    $('#exampleOrganization tbody').on('click', '.btnDeleteOrganization', function () {
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
                    url: "organization/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script organization

//script qualification employee


$(function () {
    $('#exampleQualificationEmployee').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 5]
            },
            {
                "visible": false,
                "targets": [3, 4]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddQualificationEmployee").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idqualificationemployee').value = id;
    });
});

$(function () {
    $(".btnEditQualificationEmployee").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        var fla = $('#exampleQualificationEmployee').dataTable().fnGetData($row)[3];
        document.getElementById('getQualificationEmployee').value = fla;
        var id = $('#exampleQualificationEmployee').dataTable().fnGetData($row)[4];
        document.getElementById('getIdQualificationEmployee').value = id;

    });
});

$(function () {
    var table = $('#exampleQualificationEmployee').DataTable();

    $('#exampleQualificationEmployee tbody').on('click', '.btnDeleteQualificationEmployee', function () {
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
                    url: "qualificationEmployee/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script qualification employee

//script training

$(function () {
    $('#exampleTraining').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 3, 5]
            },
            {
                "visible": false,
                "targets": [4]
            }
        ],
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddTraining").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idtraining').value = id;
    });
});

$(function () {
    $(".btnEditTraining").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getNameTraining').value = $row.find('td:eq(1)').text();
        document.getElementById('getDescriptionTraining').value = $row.find('td:eq(2)').text();
        document.getElementById('getCertificate').value = $row.find('td:eq(3)').text();
        var id = $('#exampleTraining').dataTable().fnGetData($row)[4];
        document.getElementById('getIdTraining').value = id;

    });
});

$(function () {
    var table = $('#exampleTraining').DataTable();

    $('#exampleTraining tbody').on('click', '.btnDeleteTraining', function () {
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
                    url: "training/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script training

//script work assignment
$(function () {
    $('#exampleWorkAssignment').DataTable({
        'paging': false,
        'lengthChange': false,
        'searching': false,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [0, 1, 2, 3, 4, 5, 7]
            },
            {
                "visible": false,
                "targets": [6]
            }
        ],
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search..."
        },
        'info': false,
        'autoWidth': false
    });
}
);

$(function () {
    $(".btnAddWorkAssignment").click(function () {
       var btn = $(this), id = btn.data('id');
        
        document.getElementById('idwork').value = id;
    });
});

$(function () {
    $(".btnEditWorkAssignment").click(function () {
//        var exyear, exmonth, exday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());

        var starts = new Date($row.find('td:eq(1)').text()),
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
        var ends = new Date($row.find('td:eq(2)').text()),
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
        document.getElementById('getStartWork').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndWork').value = [eyear, emonth, eday].join('-');
        document.getElementById('getPositionWork').value = $row.find('td:eq(3)').text();
        document.getElementById('getCompany').value = $row.find('td:eq(4)').text();
        document.getElementById('getJobDescription').value = $row.find('td:eq(5)').text();
        var id = $('#exampleWorkAssignment').dataTable().fnGetData($row)[6];
        document.getElementById('getIdWork').value = id;


    });
});

$(function () {
    var table = $('#exampleWorkAssignment').DataTable();

    $('#exampleWorkAssignment tbody').on('click', '.btnDeleteWorkAssignment', function () {
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
                    url: "workAssignment/delete/" + id
                });
            } else {
                swal("Cancelled", "Your imaginary file is safe :)", "error");
            }
        });
    });
});
//script work assignment