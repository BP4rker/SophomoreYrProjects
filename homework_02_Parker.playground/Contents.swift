import UIKit
print("hello")
var foodDictionary:[String:(String, Double)] =
["Pizza": ("Food", 8.75), "Sausage": ("Food",5.50), "Bagels": ("Food",2.0), "Nuts": ("Snacks",6.99), "Pineapple": ("Fruit",14.0)]
/*
func lowestPrice(_ dic: Dictionary<String,(String, Double)>) -> (keyName: String, valueNum: Double)
{
        let key = Array(dic.keys)
        var lowKey = key[0]
        let lowVal = Array(dic.values)
        var low = 10000.0
        for (_, value) in lowVal
        {
            if value < low
            {
                low = value
            }
    }
        for (key,value) in dic
        {
            if low == value.1
            {
                lowKey = key
            }
        }
    return(lowKey, low)
}
func highestPrice(_ dic: Dictionary<String,(String, Double)>) -> (keyName: String, valueNum: Double)
{
    let key = Array(dic.keys)
    var highKey = key[0]
    let highVal = Array(dic.values)
    var high = 0.0
    for (_, value) in highVal
    {
        if value > high
        {
            high = value
        }
}
    for (key,value) in dic
    {
        if high == value.1
        {
            highKey = key
        }
    }
    return(highKey, high)
}

//lowestPrice(foodDictionary)
*/
