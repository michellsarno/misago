var avaliacao = (function(){
	
	$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
		
		var button = $(event.relatedTarget);
		var codigoTitulo = button.data('codigo');
		var descricaoAvaliacao = button.data('descricao');
		var textoEntidade = button.data('texto-entidade');
		var action = button.data('url-base');
		
		var modal = $(this);
		var form = modal.find('form');
		
		if(!action.endsWith('/')){
			action +="/";
		}
		
		form.attr('action', action + codigoTitulo);
		modal.find('.modal-body span').html('Tem certeza que deseja excluir '+textoEntidade+':<br/><strong>'+descricaoAvaliacao+'</strong>?');
		
	});
	
	
	$('#containerAvaliadores').on('click', 'button.add', function(){
		
		var $linha = $(this).closest('tr');
		var $novaLinha = $linha.clone();
		
		$novaLinha.find('input').val(0);
		
		$linha.parent().append($novaLinha);
		
		validaVisualizacaoIcones($linha);
		
	});

	$('#containerAvaliadores').on('click', 'button.rem', function(){
		
		var $linha = $(this).closest('tr');
		$linha.remove();
		
		validaVisualizacaoIcones($linha);
		
	});
	
	var botaoAdicionaLinha = $('<button>', {
		type : 'button',
		text : 'Add'
	}).addClass('btn btn-outline-success btn-sm add');
	
	var validaVisualizacaoIcones = function($linhaClicada){
		
		var $tbody = $linhaClicada.closest('tbody');
		var linhas = $tbody.find('tr');
		var quantidadeLinhas = linhas.length;

		if(quantidadeLinhas == 2){
			$tbody.find('tr:first').find('td:last').append(botaoAdicionaLinha.clone());
		}
		
		
		
	};
	
	
})();