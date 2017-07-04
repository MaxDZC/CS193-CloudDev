angular.module('hplus.modules.alertDemo', [])
	.controller('demoCtrl',['SweetAlert', function(SweetAlert){
		var vm = this;
		
		console.log("Controller Got Called biatch!");
		
		vm.alert = function(){
			SweetAlert.swal("I'm a fancy Alert"); //simple alert
		}
		
		vm.confirm = function(){
			console.log("Confirm got called!");
			SweetAlert.swal({
				title: "Are you sure?", //Bold text
				text: "Your will not be able to recover this imaginary file!", //light text
				type: "warning", //type -- adds appropiriate icon
				showCancelButton: true, // displays cancel btton
				confirmButtonColor: "#254d5e",
				confirmButtonText: "Yes, delete it!",
				closeOnConfirm: false, //do not close popup after click on confirm, usefull when you want to display a subsequent popup
				closeOnCancel: false
			}, 
			function(isConfirm){ //Function that triggers on user action.
				if(isConfirm){
					SweetAlert.swal("Deleted!");
				} else {
					SweetAlert.swal("Your file is safe!");
				}
			});
		}
	}]);