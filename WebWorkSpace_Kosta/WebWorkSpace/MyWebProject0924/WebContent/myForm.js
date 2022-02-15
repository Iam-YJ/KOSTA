   // window.onload = function(){
    //   console.lof('첫번째 onload')
    // };

    // $(document).readyf=(function(){
    //   concole.log('첫번째 jquery ready');

    // });

    //jquery의 ready 함수는 window.onload와 같은 역할을 하는 함수이다
    $(document).ready(function(){
        console.log('두번째 jquery ready 함수');
        $('#myButton').click(function(){
          if ($('#username').val() == '') {
            alert('username을 입력하세요');
           $('#username').focus();
            return;
        }
          if($('#email').val()==''){
            alert('email을 입력하세요');
            $('#email').focus();
              return;
          }
  
          $('#myForm').submit();
  
        });
  
  
      });
  
  
      // //윈도우(화면)이 LOAD되는 이벤트가 발생하는 것 감지한다.
      // window.onload = function () {
      //   //document.getElementById("myButton");
      //   console.log('두번째 onload');
      // }