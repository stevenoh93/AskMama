var http = require('http');
var querystring = require('querystring');



// var options = {
// 	host: 'api.nutritionix.com', 
// 	path: '/v1_1/search', 
// 	method: 'POST',
// 	headers: {
// 		'Content-Type': 'application/x-www-form-urlencoded',
// 		'Content-Length': postData.length
//     }
// }
var restID = '';

var options = {
	host: 'api.nutritionix.com',
	path: '/v1_1/brand/search?query=chipotle&type=1&min_score=2&limit=3&appId=0001a5be&appKey=40533b881e2971ff1018187e44ae7a33'
}

http.request(options, function(response) {
	response.setEncoding('utf8');
	response.on('data', function(chunk) {
		console.log(chunk);
		console.log('\n');
		var parsedChunk = JSON.parse(chunk);
		restID = parsedChunk.hits[0]._id;

		console.log("id = " + restID);
	});
	response.on('end', function() {
		getNutrition(restID);
		console.log("END");
	});
}).end();


function getNutritionGET(restID){
	var inData = "";
	var options2 = {
		host: 'api.nutritionix.com',
		path: '/v1_1/search?brand_id=513fbc1283aa2dc80c000002&cal_min=0&fields=brand_name%2Citem_name%2Cnf_calories%2Cnf_serving_size_qty%2Cnf_serving_size_unit%2Cnf_calories%2Cnf_calories_from_fat%2Cnf_total_fat%2Cnf_saturated_fat%2Cnf_sodium%2Cnf_total_carbohydrate%2Cnf_dietary_fiber%2Cnf_sugars%2Cnf_protein%2Cnf_vitamin_a_dv%2Cnf_vitamin_c_dv%2Cnf_calcium_dv&appId=0001a5be&appKey=40533b881e2971ff1018187e44ae7a33'
	}
	http.request(options2, function(response) {
		response.setEncoding('utf8');
		response.on('data', function(chunk) {
			inData += chunk;
		});
		response.on('end', function() {
			var foodData = JSON.parse(inData);
			for(hit in foodData.hits) {
				console.log(foodData.hits[hit].fields);
				console.log(hit);
			}
			console.log("END");
		});
	}).end();
}

function getNutrition(restID) {
	var postData = JSON.stringify({
		appId:"0001a5be",
		appKey:"40533b881e2971ff1018187e44ae7a33",  
		fields:["item_name","nf_calories","nf_serving_size_qty","nf_serving_size_unit", "nf_calories", 
				"nf_calories_from_fat", "nf_total_fat", "nf_saturated_fat", "nf_sodium", "nf_total_carbohydrate",
				"nf_dietary_fiber", "nf_sugars", "nf_protein", "nf_vitamin_a_dv", "nf_vitamin_c_dv", "nf_calcium_dv"],
		queries:{
			brand_name: "Chipotle"
		},
		sort: {
			field: "nf_calories",
			order: "asc"
		},
		limit: 50
	});

	var options2 = {
		host: 'api.nutritionix.com',
		path: '/v1_1/search',
		method: 'POST',
		headers: {
          'Content-Type': 'application/json'
      	}
	} 

	//?brand_id=' + restID + '&results=0%3A20&cal_min=0&fields=item_name%2Cbrand_name%2Citem_id%2Cbrand_id&appId=0001a5be&appKey=40533b881e2971ff1018187e44ae7a33'	

	var inData = "";
	
	var post_request = http.request(options2, function(response) {
		response.setEncoding('utf8');
		response.on('data', function(chunk) {
			inData += chunk;
		});
		response.on('end', function() {
			console.log(JSON.stringify(response.headers));
			var foodData = JSON.parse(inData);
			for(hit in foodData.hits) {
				console.log(foodData.hits[hit].fields);
				console.log(hit);
			}
			console.log("END");
		});
	});

	post_request.write(postData);
	post_request.end();
}

