var app = angular.module('pcchr', ['ngDialog', 'xeditable', 'ngDragDrop', 'pcchr.controllers', 'pcchr.services']) 



// For configuring x-editable with Boot Strap 3 theme
.run(function(editableOptions, editableThemes) {
  editableOptions.theme = 'bs3';

});