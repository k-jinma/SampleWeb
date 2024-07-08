<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>A社オンラインショッピング - メールアドレス入力画面</title>
    <style>
        .head-a:hover {
            color: white;
        }
        .head-a:link{
            color: white;
        }
        .head-a:visited{
            color: white;
        }

        header {
            width: 100%;
            height: 60px;
            background-color: #003399;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between; /* 左右の要素を両端に配置 */
			padding: 0 10px; /* 左右に10pxのパディングを追加 */
			box-sizing: border-box; /* パディングを含む幅を指定 */
        }
        footer {
            width: 100%;
            height: 60px;
            //background-color: #003399;
            border-top: 1px solid #0099cc;
            //color: white;
            display: flex;
            align-items: center;
            justify-content: flex-end; /* テキストの右寄せ */
			padding: 0 10px; /* 左右に10pxのパディングを追加 */
			box-sizing: border-box; /* パディングを含む幅を指定 */
        }
        .left-align {
            text-align: left;
        }
        .right-align {
            text-align: right;
        }
        .message {
        	color: red;
        }
        
    </style>
</head>
<body>
    <header>
        <div class="left-align">
            <h1>A社オンラインショッピング</h1>
        </div>
        <div class="right-align">
            <p>ようこそゲスト様<br>
            <a class="head-a" href="#">ログイン</a> <a class="head-a" href="#">会員登録</a></p>
        </div>
    </header>

	<main>
		<p>メールアドレス入力</p>
		<p class="message">${message}</p>
		<form action="/SampleWeb/member" method="post">
			メールアドレス　<input type="text" name="mailaddress">
			<br>
			<input type="submit" value="確認">
		</form>
		<a href="#">トップに戻る</a>

	</main>
	
    <footer>
        <p>&copy;2022 A社</p>
    </footer>
</body>
</html>
