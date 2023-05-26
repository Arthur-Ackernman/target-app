import React, { useEffect, useState } from 'react';
import {ImageBackground, Button, StyleSheet, Text, View, Alert} from 'react-native';
import { Target, TargetParameters, TargetPrefetchObject, TargetRequestObject  } from '@adobe/react-native-aeptarget';

const Main = ({ navigation }) => {

  const [targetContent, setTextBtn] = useState("Home-default")
  const parameters1 = new TargetParameters({}, {}, undefined, undefined)

  useEffect(() => {
    const requestObject = new TargetRequestObject(
      'app-target-mbox',
      parameters1,
      'personalizado',
      (error, content) => {
        if (error) {
          console.error(error);
        } else {
          if(content) {
            let contentObj = JSON.parse(content)
            console.log('***', contentObj, typeof contentObj.button)
            setTextBtn(contentObj["button"]);
          }
          console.log("Adobe content TargetRequestObject:", content);
          }
        });
        Target.retrieveLocationContent([requestObject], parameters1);
      }, [] );

  return (
    <View style={styles.container}>
      <ImageBackground source={require('../assets/pattern.jpg')}  resizeMode="cover" style={styles.image}>
        <Text style={styles.text}>Inside</Text>
        <View style={styles.containerBtn}>
        <Button
          title="Press me"
          onPress={() => Alert.alert('Button pressed')}
        />
        <Button
          title="Show Alert"
          color="#f194ff"
          onPress={() => Alert.alert('Click buttons')}
        />
        <Button
          title={targetContent}
          onPress={() => {
            navigation.navigate('Home');
          }}
        />

        </View>
      </ImageBackground>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  image: {
    flex: 1,
    justifyContent: 'center',
  },
  text: {
    color: 'white',
    fontSize: 42,
    lineHeight: 84,
    fontWeight: 'bold',
    textAlign: 'center',
    backgroundColor: '#000000c0',
  },
  containerBtn:{
    justifyContent: 'flex-end'
  }
  });

export default Main;
