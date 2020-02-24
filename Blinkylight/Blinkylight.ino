void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT); //Pin and then output because it is producing electricity

}

void loop() {
  Serial.println("Hello!");
  digitalWrite(13,HIGH); //Turns on LED by producing 5v
  delay(1300);
  digitalWrite(13,LOW);
  delay(500);

}
