﻿var dataTable;

$(document).ready(() => {
    loadDataTable();
});

function loadDataTable() {
    dataTable = $('#DT_load').DataTable({
        "ajax": {
            "url": "/api/book",
            "type": "GET",
            "datatype": "json"
        },
        "columns": [
            { "data":"name", "width": "20%"},
            { "data":"author", "width": "20%"},
            { "data":"isbn", "width": "20%" },
            {
                "data": "id",
                "render": (data) => {
                    return `<div class="text-center">
                        <a href="/BookList/Upsert?id=${data}" class='btn btn-success text-white' style='cursor:pointer; width:70px;'>
                            Edit
                        </a>
                        &nbsp;
                        <a class='btn btn-danger text-white' style='cursor:pointer; width:70px;'
                            onclick=Delete('/api/book?id='+${data})>
                            Delete
                        </a>
                    </div>`;
                }, "width": "40%"
            }
        ],
        "language": {
            "emptyTable":"no data found"
        },
        "width":"100%"
    })
}

function Delete(url) {
    new swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover",
        icon: "warning",
        showConfirmButton: true,
        showCancelButton: true
    }).then((willDelete) => {
        if (willDelete.isConfirmed) {
            $.ajax({
                type: "DELETE",
                url: url,
                success: function (data) {
                    console.log(data)
                    if (data.success) {
                        toastr.success(data.message);
                        dataTable.ajax.reload();
                    } else {
                        toastr.error(data.message);
                    }
                }
            });
        }
    });
}