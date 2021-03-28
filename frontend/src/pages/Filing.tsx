import {
  IonButton,
  IonContent,
  IonGrid,
  IonHeader,
  IonIcon,
  IonList,
  IonPage,
  IonRow,
  IonTitle,
  IonToolbar,
} from "@ionic/react";
import { refreshOutline } from "ionicons/icons";
import React, { useEffect, useLayoutEffect, useState } from "react";
import FilingComponent from "../components/FilingComponent";
import { Filing } from "../interfaces/FurnitureTypes";

const Filings: React.FC = () => {
  const [filings, setFilings] = useState<Array<Filing>>();

  const updateFilings = () => {
    fetch(`http://localhost:8080/filings`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new lamps:", data);
        setFilings(data as Array<Filing>);
      });
  };

  useLayoutEffect(() => {
    updateFilings();
  }, []);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonGrid>
            <IonRow>
              <IonTitle>Available Filing Cabinets</IonTitle>
              <IonButton onClick={updateFilings}>
                <IonIcon src={refreshOutline} />
              </IonButton>
            </IonRow>
          </IonGrid>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonList>
          {filings?.map((v, k) => {
            return <FilingComponent filing={v} key={k} />;
          })}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Filings;
