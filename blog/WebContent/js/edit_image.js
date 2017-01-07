function readURL(input) {  
            if (input.files && input.files[0]) {  
                var reader = new FileReader();  
                reader.onload = function (e) {  
                    $('#displayImg').removeAttr('src');  
                    $('#displayImg').attr('src', e.target.result);  
                    var api = $('#displayImg').Jcrop({  
                        setSelect: [ 20, 20, 200, 200 ],  
                        aspectRatio: 1,  
                        onSelect: updateCoords  
                        }  
                    );  
                }  
  
                reader.readAsDataURL(input.files[0]);  
            }  
              
              
        }  
        function updateCoords(c){     
            $('#x').val(c.x);  
            $('#y').val(c.y);  
            $('#w').val(c.w);  
            $('#h').val(c.h);  
 };  