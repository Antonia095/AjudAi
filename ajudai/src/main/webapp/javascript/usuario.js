$('.dropdown-trigger').dropdown();

$('#search').keypress(function(event){
    if(event.which==13){
        alert(event.code)
    }
});