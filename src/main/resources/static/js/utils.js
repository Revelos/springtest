/**
 * 
 */

function load(){

		document.body.addEventListener("click",(e)=>{
			if(e.target.id=="eliminar"){
				if(!confirm("Seguro que desea eliminar el registro")){
					e.preventDefault();
				}
			}
			
		})
}
	
	
window.addEventListener("load", load, false);

$("#Cuenta").change(function (event) {
    var id = $(this).val();
    var band;
    console.log(id+"cambio hdp");
     $.ajax({
       
       url: "/getCuenta/"+id,
       data: {id: id},
       type: 'GET',
       dataType: 'text',
       success: function (data) {
         console.log('fue existoso '+data);
         $("#saldo").val(data);

       },
       error : function (xhr,status){
    	   console.log("error "+JSON.Stringify(xhr)+ status)
       }
     });


});

$("#valor").keyup((e)=>{
	
	e.preventDefault();
	var saldo = $("#saldo").val();
	var valor = $("#valor").val();
	var transa =  $("#Transaccion option:selected").text();
	console.log(saldo+valor+transa);
	if(parseFloat(valor)>parseFloat(saldo) && transa=='Retirar'){
		console.log('Entra');
		 $('#error').show();
         $('#error').html('No hay saldo suficiente para la transaccion');
         $('#error').fadeOut(5000).hide(500);
         $("#valor").val('');
	}
});

$(".modalBtn").click(function(){
	var row = $(this).closest("tr").find(".id").text();
	
	
	$('.modal-content').load('/transaccion/'+row,function(){
		$("#exampleModal").modal({show:true})
	})
});

$("#duis").keypress(function(){
	if($(this).val().length == 8) {
            $(this).val($(this).val()+"-");
           
        }
})

