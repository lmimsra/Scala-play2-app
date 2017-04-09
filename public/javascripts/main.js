if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

//入力ページへ
function gotoInput() {
  location.href="/input";
}
//トップページへ
function gotoTop() {
  location.href="/";
}

//デフォルトのようこそページへ
function gotoWellcome() {
  location.href="/wellcome";
}
//カウンターデモ
function gotoCount() {
  location.href="/count"
}
//メッセージの表示
function gotoMessage() {
  location.href="/message"
}
//DB接続ページへ飛ぶ
function gotoDBAccess() {
  location.href="/indexing"
}

//入力チェック
function inputCheck1() {
  var flag = 0;
  
  // チェック
  if(document.dbform.id.value.match(/[^0-9]+/)){
    flag = 1;
  }
  else if(document.dbform.author_id.value.match(/[^0-9]+/)){
    flag = 1;
  }
  
  // 判定に応じて作動
  if(flag){
    document.error_ms = "入力内容が間違っています" // 数字以外が入力された場合はエラーメッセージを表示
    return false; // 送信を中止
  }
  else{
    return true; // 送信を実行
  }
}