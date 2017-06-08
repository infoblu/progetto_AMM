function stateSuccess(data, state){       
    kount=0;
    $("#olUtenti").empty();
    for(var instance in data){
        usr=data[instance];
        link = $("<a>")
                .attr("href", "Bacheca?user="+usr.id)
                .html(usr.nome + " " + usr.cognome);  
        kount++;
        var li = $("<li>").attr("id","li_"+kount);
        $("#olUtenti").append(li);
        $("#li_"+kount).append(link);
    }
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function() {
    $("#nomeUtente").keyup(function(){    
    var testoRicerca = $("#nomeUtente")[0].value;
    var comando="";
    if (testoRicerca==="") comando="all";
    else comando="search";
    
        $.ajax({
            url: "Filter",
            data:{
                cmd: comando,
                nomeUtenteCercato: testoRicerca
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data,state);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});


