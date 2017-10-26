  function exebirbarra(){
                 var elemento = document.getElementById("myBar");
                 var width = 1;
                 var id = setInterval(frame,10);
                 
                 function frame(){
                     if(width >=100 ){
                         clearInterval(id);
                     }else{
                         width++;
                         elemento.style.width = width + "%"
                     }
                 }
             }
            
           var progressbar = $( ".progressbar" ),
			progressLabel = $( "#progress-label" );

		progressbar.progressbar({
			value: false,
			change: function() {
				progressLabel.text( progressbar.progressbar( "value" ) + "%" );
			},
			complete: function() {
				progressLabel.text( "Complete!" );
			}
		});

		function progress() {
			var val = progressbar.progressbar( "value" ) || 0;

			progressbar.progressbar( "value", val + 2 );

			if ( val < 99 ) {
				setTimeout( progress, 80 );
			}
		}

		setTimeout( progress, 2000 );
            
