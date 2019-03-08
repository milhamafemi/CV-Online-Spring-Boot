//script achievement
//$("#srcData").on("keyup", function () {
//    var value = $(this).val().toLowerCase();
//    $("#tblDataAchievement tr").filter(function () {
//        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
//    });
//});
//
//$(function () {
//    $('#exampleAchievement').DataTable({
//        'paging': true,
//        'lengthChange': true,
//        'searching': true,
//        'columnDefs': [{orderable: false, targets: [1]},
//        ],
//        language: {
//            search: "_INPUT_",
//            searchPlaceholder: "Search..."
//        },
//        'info': true,
//        'autoWidth': false
//    })
//}
//)
//
//$(function () {
//    $(".btnEditAchievement").click(function () {
//        var $row = $(this).closest("tr"), // Finds the closest row <tr>
//                $tds = $row.find("td"); // Finds all children <td> elements
//
//        $("#id").val($row.find('td:eq(1)').text());
//        document.getElementById('getIdAchievement').value = $row.find('td:eq(1)').text();
//        document.getElementById('getNameAchievement').value = $row.find('td:eq(2)').text();
//        document.getElementById('getDescriptionAchievement').value = $row.find('td:eq(3)').text();
//
//    });
//});
//
//$(function () {
//    var table = $('#exampleAchievement').DataTable();
//
//    $('#exampleAchievement tbody').on('click', '.btnDeleteAchievement', function () {
//        var btn = $(this), id = btn.data('id');
//        swal({
//            title: "Are you sure?",
//            text: "You will not be able to recover this imaginary file!",
//            type: "warning",
//            showCancelButton: true,
//            confirmButtonClass: 'btn-danger',
//            confirmButtonText: 'Yes, delete it!',
//            cancelButtonText: "No, cancel plx!",
//            closeOnConfirm: false,
//            closeOnCancel: false
//        }, function (isConfirm) {
//            if (isConfirm) {
//                swal("Deleted!", "Your imaginary file has been deleted!", "success");
//                table.row($(btn).parents('tr')).remove().draw(false);
//                $.ajax({
//                    type: 'POST',
//                    url: "achievement/delete/" + id
//                });
//            } else {
//                swal("Cancelled", "Your imaginary file is safe :)", "error");
//            }
//        });
//    });
//});
//script achievement

//scrip certification
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataCertification tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleCertification').DataTable({
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

$(function () {
    $(".btnEditCertification").click(function () {
//        var exyear, exmonth, exday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());

        var exp = new Date($row.find('td:eq(3)').text()),
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
        document.getElementById('getIdCertification').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameCertification').value = $row.find('td:eq(2)').text();
        document.getElementById('getExpiredDate').value = [exyear, exmonth, exday].join('-');
        document.getElementById('getDescriptionCertification').value = $row.find('td:eq(4)').text();

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataEducation tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleEducation').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [4]
            },
            {
                "visible": false,
                "targets": [7]
            }
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

$(function () {
    $(".btnEditEducation").click(function () {
//        var exyear, exmonth, exday;
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
        document.getElementById('getIdEducation').value = $row.find('td:eq(1)').text();
        document.getElementById('getStartMU').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndMU').value = [eyear, emonth, eday].join('-');
        document.getElementById('getIP').value = $row.find('td:eq(4)').text();
        var mu = $('#exampleEducation').dataTable().fnGetData($row)[7];
        document.getElementById('getMajorUniversity').value = mu;

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataExperience tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleExperience').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [
            {
                "orderable": false,
                "targets": [4]
            },
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

$(function () {
    $(".btnEditExperience").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getIdExperience').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameExperience').value = $row.find('td:eq(2)').text();
        document.getElementById('getDescriptionExperience').value = $row.find('td:eq(3)').text();

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataLanguageEmployee tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleLanguageEmployee').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [{
                "orderable": false,
                "targets": [4]
            },
            {
                "visible": false,
                "targets": [3]
            }
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

$(function () {
    $(".btnEditLanguageEmployee").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getIdLanguage').value = $row.find('td:eq(1)').text();
        var fla = $('#exampleLanguageEmployee').dataTable().fnGetData($row)[3];
        document.getElementById('getForeignLanguage').value = fla;

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataOrganization tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleOrganization').DataTable({
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

$(function () {
    $(".btnEditOrganization").click(function () {
//        var exyear, exmonth, exday;
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());

        var starts = new Date($row.find('td:eq(4)').text()),
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
        var ends = new Date($row.find('td:eq(5)').text()),
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
        document.getElementById('getIdOrganization').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameOrganization').value = $row.find('td:eq(2)').text();
        document.getElementById('getPositionOrganization').value = $row.find('td:eq(3)').text();
        document.getElementById('getStartDateOrganization').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndDateOrganization').value = [eyear, emonth, eday].join('-');

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataQualificationEmployee tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleQualificationEmployee').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': true,
        'columnDefs': [{
                "orderable": false,
                "targets": [4]
            },
            {
                "visible": false,
                "targets": [4]
            }
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

$(function () {
    $(".btnEditQualificationEmployee").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getIdQualificationEmployee').value = $row.find('td:eq(1)').text();
        var fla = $('#exampleQualificationEmployee').dataTable().fnGetData($row)[4];
        document.getElementById('getQualificationEmployee').value = fla;

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataTraining tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleTraining').DataTable({
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

$(function () {
    $(".btnEditTraining").click(function () {
        var $row = $(this).closest("tr"), // Finds the closest row <tr>
                $tds = $row.find("td"); // Finds all children <td> elements

        $("#id").val($row.find('td:eq(1)').text());
        document.getElementById('getIdTraining').value = $row.find('td:eq(1)').text();
        document.getElementById('getNameTraining').value = $row.find('td:eq(2)').text();
        document.getElementById('getDescriptionTraining').value = $row.find('td:eq(3)').text();
        document.getElementById('getCertificate').value = $row.find('td:eq(4)').text();

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
$("#srcData").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("#tblDataWorkAssignment tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

$(function () {
    $('#exampleWorkAssignment').DataTable({
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

$(function () {
    $(".btnEditWorkAssignment").click(function () {
//        var exyear, exmonth, exday;
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
        document.getElementById('getIdWork').value = $row.find('td:eq(1)').text();
        document.getElementById('getStartWork').value = [syear, smonth, sday].join('-');
        document.getElementById('getEndWork').value = [eyear, emonth, eday].join('-');
        document.getElementById('getPositionWork').value = $row.find('td:eq(4)').text();
        document.getElementById('getCompany').value = $row.find('td:eq(5)').text();
        document.getElementById('getJobDescription').value = $row.find('td:eq(6)').text();


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