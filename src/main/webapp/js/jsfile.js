
//基本とあるサイトの奴をそのままコピペして、細かい所のみ変更している。
$(window).on('load',function(){
$("#splash-logo").delay(1500).fadeOut('slow');//ロゴをフェードアウトする記述
	const message1 = document.getElementById('Loading_mes');
	
	const messages = [
	  'Loading.',
	  'Loading..',
	  'Loading...',
	  'Loading....',
	  'Loading.....',
	  'Loading......',
	  'Loading.......',
	];
	
	let i = 0;
	
	function showMessage_1() {
	  if (i == 8) {
	  }
	  message1.textContent = messages[i];
	  i++;
	}
	
	//0.3秒間隔で表示内容の変更をしている。
	setInterval(showMessage_1, 300);

//=====ここからローディングエリア（splashエリア）をフェードアウトした後に動かしたいJSをまとめる
$("#splash").delay(1200).fadeOut('slow',function(){//ローディングエリア（splashエリア）をフェードアウトする記述
	$('body').addClass('appear');//フェードアウト後bodyにappearクラス付与
});


//=====ここまでローディングエリア（splashエリア）をフェードアウトした後に動かしたいJSをまとめる


//=====ここから背景が伸びた後に動かしたいJSをまとめたい場合は
$('.splashbg').on('animationend', function() { 
//この中に動かしたいJSを記載
});
//=====ここまで背景が伸びた後に動かしたいJSをまとめる

});