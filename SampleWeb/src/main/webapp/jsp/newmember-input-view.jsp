<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録画面</title>
</head>
<body>
	<form action="/SampleWeb/member?path=newmember-input" method="post">
		<table>
			<tr>
				<td>会員ID</td>
				<td><input type="text" name="email" size="30" value=${email} disabled></td>
				<input type="hidden"name="memberId" value=${email}>
			</tr>
			<tr>
				<td>名前</td>
				<td><input type="text" name="memberName"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<label><input type="radio" name="gender" value="1">男</label>
					<label><input type="radio" name="gender" value="2">女</label>
				</td>
			</tr>
			<tr>
				<td>住所</td>
				<td><input type="text" name="address" size="50"></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>パスワード（確認）</td>
				<td><input type="password" name="passwordChk"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登録"></td>
			</tr>
		</table>
	</form>
	<a href="#">トップに戻る</a>
</body>
</html>