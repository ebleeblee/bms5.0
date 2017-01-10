jQuery(function($){
	// 에러메시지 있으면 출력
	if($('#error_msg').length) {
		if($('#error_msg').val().length > 0) {
			alert($('#error_msg').val());
		}	
	}
	
	// 최대 줄 수
	if($('#set_max_rows').length) {
		if($('#max_rows').length) {
			$('#set_max_rows').val($('#max_rows').val());
		}
		$('#set_max_rows').on('change', function() {
			var url = $(this).data('url') + '&current_page=1&max_rows=' + $(this).val();
			$(location).attr('href',url);
		});
	}
	
	// 페이지 이동 이벤트
	if($('.go_page').length) {
		$('.go_page').on('click', function() {
			var url = $(this).data('url') + '&max_rows=' + $('#set_max_rows').val();
			$(location).attr('href',url);
		});
	}
	
	// 탭 active
	$(function(){
		  var book_status = $('#book_status').val();
		  
		  if (book_status == 'accept') {
		       			$('#tabAccept').removeClass('active');
		       			$('#tabAccept').addClass('active');
		  } else if (book_status == 'rejection') {
			  			$('#tabRejection').removeClass('active');
			       		$('#tabRejection').addClass('active');
		  } else if (book_status == 'holding') {
			  			$('#tabHolding').removeClass('active');
			  			$('#tabHolding').addClass('active');
		  } else {
			  			$('#tabAll').removeClass('active');
			  			$('#tabAll').addClass('active');
		  }
	});
});