var copyTextareaBtn = document.querySelector('.copiar');

copyTextareaBtn.addEventListener('click', function(event) {

    console.log('click click');

    var copyTextarea = document.querySelector('.link-short');
    copyTextarea.select();

    document.execCommand('copy');
});

$("#form-short").submit(function(event){
    event.preventDefault();
    console.log('entrou no submit');
    $("#result-link").show();
    
    var dado = {url: 'google.com/flamengo',
    		customAlias:'tabajara'};
    
    console.log(dado);
    
    //var uri = '/hire.me/encurtar/criar2?url=g1.com.br&alias=fly';
    var uri = '/hire.me/encurtar/criar2';

    var linkGerado = document.querySelector('#link-gerado');
    linkGerado.value = 'word';
    
    $.ajax( {
    	url: uri,
    	data: dado,
    	method :'POST'
    })
    .done(function(obj) {
      console.log( "success" );
      console.log(obj);
    })
    .fail(function() {
      console.log( "error" );
    })
    .always(function() {
      console.log( "complete" );
    });
    
});

$("#hide").click(function(){
    
    $("#result-link").hide();
});

$("#show").click(function(){
    
    $("#result-link").show();
});  




