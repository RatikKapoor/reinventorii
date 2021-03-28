import {
  IonButton,
  IonContent,
  IonHeader,
  IonPage,
  IonTitle,
  IonToolbar,
} from "@ionic/react";
import { useEffect, useState } from "react";
import { Chair } from "../interfaces/FurnitureTypes";
import "./Tab1.css";

const Chairs: React.FC = () => {
  const [chairs, setChairs] = useState<Array<Chair>>();

  // useEffect(() => {
  //   console.log(RESTManager.GetChairs());
  //   return () => {};
  // }, []);

  const updateChairs = () => {
    fetch(`http://localhost:8080/chairs`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new chairs:", data);
        setChairs(data as Array<Chair>);
      });
  };

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Available Chairs</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonTitle>Available Chairs</IonTitle>
        <IonButton onClick={updateChairs}>Get chairs</IonButton>
      </IonContent>
    </IonPage>
  );
};

export default Chairs;
