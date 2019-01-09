(function () {
	var app = angular.module('store', [ ]);


	app.controller('StoreController', function () {
		this.products = gems;
	});

	var gems = [
		{
			name: 'Dodecahedron',
			price: 2,
			description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab laboriosam, voluptatibus libero accusantium nisi ipsa cumque, iusto deserunt quas vero quisquam delectus aliquid autem veritatis! Illo nobis beatae earum eius.',
			canPurchase: true,
		},
		{
			name: 'Pentagonal Gem',
			price: 5.95,
			description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab laboriosam, voluptatibus libero accusantium nisi ipsa cumque, iusto deserunt quas vero quisquam delectus aliquid autem veritatis! Illo nobis beatae earum eius.',
			canPurchase: false,
		}
	];

})();
