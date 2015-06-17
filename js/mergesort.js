// http://jsfiddle.net/ry03mr5p/

var a = [22,84,34,67,71,55,44,19,16];
console.log(mergesort(a));

function mergesort(array){
    if(array.length === 1)
        return array;
    
    var length = array.length;
    var mid = length/2;
    
    var left = mergesort(array.slice(0,mid));
    var right = mergesort(array.slice(mid, length));
    
    return merge(left, right);
}

function merge(left, right){
    console.log(left);
    console.log(right);
    var orderedArray = new Array();
    while(left.length && right.length){
        if(left[0] < right[0]){
            orderedArray.push(left[0]);
            left.shift();
        } else {
            orderedArray.push(right[0]);
            right.shift();
        }
    }
    while(left && left.length > 0){
        orderedArray.push(left[0]);
        left.shift();
    }
    
    if(right && right.length > 0){
        orderedArray.push(right[0]);
        right.shift();
    }
    
    return orderedArray;
}
