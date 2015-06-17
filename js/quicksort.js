var a = [2,8,3,7,1,5,4,9,6];
console.log(quicksort(a));

function quicksort(array){    
    if(array.length == 0){
        return [];
    }
    console.log(array);
    var pivotPosition = getRandomFromZero(array.length);
    var pivot = array[pivotPosition];
    console.log(pivot);
    var left = [];
    var right = [];
    for(var i = array.length-1; i >= 0; i--) {
        if(array[i] > pivot) {
        	right.push(array[i]);
        } else if(array[i] != pivot){
        	left.push(array[i]);
        }
    }
    
    left = quicksort(left);
    right = quicksort(right);
    left.push(pivot);
    var ordered = left.concat(right);
    return ordered;
}

function getRandomFromZero(max) {
    return Math.floor(Math.random() * (max));
}