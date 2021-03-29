$(".icon-search").click(function() {
    var searchstring  = $(this).text('#searchfield');// $('#searchfield');
    searchstring.focus();
    $('#searchBox').html($('input:searchfield').val());
    alert("searchfield.  " + searchstring +  " hahah");
});

function editAddRowLecturer(rowID,firstname,lastname,
                            // abbr,type,comment,
                            // cloneRow
){
    let lecturerId = +rowID;
    let lecturerFirstName = firstname===""?" ":firstname;
    let lecturerLastName = lastname;
    // let lecturerAbbr = abbr;
    // let lecturerType = type===""?" ":type;
    // let lecturerComment = comment===""?" ":comment;

    //Nach Pflichtfelder prüfen
    if(lecturerLastName!=="" && lecturerAbbr!==""){
        let optionValueListType = $( "#selectListType").val();
        let optionValueListYear = $("#selectListYear").val();
        $.ajax({
            type: "get",
            url: "client/search",
            data: {
                "clientID":lecturerId,
                "lecturerFirstName":lecturerFirstName,
                "lecturerLastName":lecturerLastName,
                // "lecturerAbbr":lecturerAbbr,
                // "lecturerType":lecturerType,
                // "lecturerComment":lecturerComment,
                "cloneRow":cloneRow
            },
            success: function(){
                sessionStorage.setItem("reloading","true");
                sessionStorage.setItem("optionValueListType",optionValueListType);
                sessionStorage.setItem("optionValueListYear",optionValueListYear);
                location.reload(true);
            }
        });
    }else{
        checkInputFieldsIfEmpty('#basicModalAddEditLecturer');
    }
}



$("#myModal.modal-body #type").val(lecturerType);
// $("#myModal .modal-body #comment").val(lecturerComment);


// function createFolder(folderName) {
//     let optionValueListType = $("#selectListType").val();
//     let optionValueListYear = $("#selectListYear").val();
//     $.ajax({
//         type: "get",
//         url: "CreateSubFolder", //here you can use servlet,jsp, etc
//         data: {
//             "optionValueListType":optionValueListType,
//             "optionValueListYear":optionValueListYear,
//             "folderName":folderName
//         },
//         success: function(){
//             // Before reloading the page, set "RELOADING" to true as marker
//             // Store which options have been clicked
//             sessionStorage.setItem("reloading","true");
//             sessionStorage.setItem("optionValueListType",optionValueListType);
//             sessionStorage.setItem("optionValueListYear",optionValueListYear);
//             location.reload(true);
//         }
//     });
// }