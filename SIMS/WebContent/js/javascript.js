function error(){
    alert("Username or Password error!");
}
function isEmpty(){
    alert("Username or Password is empty!");
    return false;
}
function somethingEmpty(){
    alert("Please confirm that you have filled in all!");
    return false;
}
function notExistSpace(str){
var arr = new Array();
arr = str.split(" ");
if(arr.length == 1) return false;
return true;
}
//index.jsp
function chooseRemember(un){
    document.getElementById("remember").checked = true;
}
function updateSuccess(){
    alert("Password has been updated, please login again!");
}
//ul.jsp
function very(aa){
    //alert(aa);
    var s;
    if(aa == "0") s = "Super Admin";
    else if(aa == "1") s = "Admin";
    else if(aa == "2") s = "Teacher";
    else if(aa == "3") s = "Student";
    document.write(s);
}
function addUser(){
    window.location.href = "gotoAddUser.sims";
}
function checkQueryUser(){
    var queryBy = document.getElementById("queryBy").value;
    var query = document.getElementById("query").value;
    var href = "queryUser.sims?query="+query+"&queryBy="+queryBy;
    //alert("|"+href+"|");
    if(query == "")
        alert("Please enter the content to be queried!")
    else
        window.location.href = href;
}
function chooseQueryBy(queryBy){
    document.getElementById("queryBy").value = queryBy;
}
function deleteSuccess(){
    alert("Successfully deleted!");
}
//user.jsp
function checkUser(){//is fault
    //alert("enter check");
    //return false;
    var nickname = document.getElementById("nickname").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirmPW = document.getElementById("confirmPW").value;
    var adminAty = document.getElementById("adminAty").value;
    if(notExistSpace(nickname) || notExistSpace(username) || notExistSpace(password) || notExistSpace(confirmPW)){
        alert("Please do not enter spaces");
        return false;
    }
    if(password != confirmPW){ alert("Two passwords are inconsistent!"); return false; }
    //alert(adminAty + isNaN(username));
    if(adminAty == "3" && isNaN(username)){
        alert("Student's username can only be Student ID");
        return false;
    }
    return true;
}
function chooseUser(aa){
    document.getElementById("adminAty").value = aa;
}
function changeCPW(){
    var pw = document.getElementById("password").value;
    document.getElementById("confirmPW").value = pw;
}
//sl.jsp
function addStu(){
    window.location.href = "gotoAddStu.sims";
}
function checkQueryStu(){
    var queryBy = document.getElementById("queryBy").value;
    var query = document.getElementById("query").value;
    var href = "queryStu.sims?query="+query+"&queryBy="+queryBy;
    //alert("|"+href+"|");
    if(query == "")
        alert("Please enter the content to be queried!")
    else
        window.location.href = href;
}
function forwardPage(){
    var page = document.getElementById("page").value;
    window.location.href = "updatePage.sims?page=" + page;
}
function chooseStu(queryBy, display, orderBy, order){
    chooseQueryBy(queryBy);
    document.getElementById("display").value = display;
    document.getElementById("orderBy").value = orderBy;
    document.getElementById("order").value = order;
}
function display(e){
    if(e.value == "all") window.location.href = "display.sims?display=all";
    else window.location.href = "display.sims?display=page";
}
function orderBy(e){
    window.location.href = "orderBy.sims?orderBy=" + e.value;
}
function order(e){
    window.location.href = "order.sims?order=" + e.value;
}
function goPage(page){
    window.location.href = "updatePage.sims?page="+page;
}
//student.jsp
function checkStudent(){
    //alert("enter cs");
    var num = document.getElementById("num").value;
    var name = document.getElementById("name").value;
    var sex = document.getElementById("sex").value;
    var birth = document.getElementById("birth").value;
    var tel = document.getElementById("tel").value;
    var score = document.getElementById("score").value;
    if(isNaN(num) || isNaN(birth) || isNaN(tel) || isNaN(score)){
        alert("Num,Birth,Tel and Score must be a number!");
        return false;
    }
    return true;
}
//modify.jsp
function check(){
    var npw = document.getElementById("npw").value;
    var cpw = document.getElementById("cpw").value;
    if(npw == cpw) return true;
    alert("Two passwords are inconsistent!");
    return false;
}
