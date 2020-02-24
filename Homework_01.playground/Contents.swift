import UIKit

//creating a dictionary with string keys and double values
var foodDictionary:[String:Double] =
    ["Pizza": 8.75, "Sausage": 5.50, "Spaghetti": 3.0, "Nuts": 6.99, "Pineapple": 14.0]

//Separating the values and keys
var values = Array(foodDictionary.values)
var keys = Array(foodDictionary.keys)

//Declaring all variables used
var high = values[0]
var high_name = keys[0]
var low = values[0]
var low_name = keys[0]
var ave = 0.0
var sum = 0.0

//Loop to iterate through the values in the dictionary
for i in 0 ..< values.count
{
    //getting the sum of values
    sum += values[i]
    
    //finds the highest price and sets the key and value to highest
    if values[i] > high{
        high = values[i]
        high_name = keys[i]
    }
    //finds the lowest price and sets the key and value to lowest
    if values[i] < low {
        low = values[i]
        low_name = keys[i]
    }
}
//gets the average of the values
ave = sum/Double(values.count)

//formatted print statements
print("The highest price is $\(high) which is \(high_name)")
print("The lowest price is $\(low) which is \(low_name)")
print("The average price is $\(ave)")
