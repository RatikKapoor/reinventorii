import {
  IonButton,
  IonCol,
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
import { useEffect, useLayoutEffect, useState } from "react";
import { refreshOutline } from "ionicons/icons";
import ChairComponent from "../components/ChairComponent";
import { Chair } from "../interfaces/FurnitureTypes";

/**
 * Page for listing of all chairs
 * @returns page to be rendered
 */
const Chairs: React.FC = () => {
  const [chairs, setChairs] = useState<Array<Chair>>();

  /**
   * update chairs from the database
   */
  const updateChairs = () => {
    fetch(`http://localhost:36295/chairs`)
      .then((data) => data.json())
      .then((data) => {
        console.log("Got new chairs:", data);
        setChairs(data as Array<Chair>);
      });
  };

  useLayoutEffect(() => {
    updateChairs();
  }, []);

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonGrid>
            <IonRow>
              <IonTitle>Available Chairs</IonTitle>
              <IonButton onClick={updateChairs}>
                <IonIcon src={refreshOutline} />
              </IonButton>
            </IonRow>
          </IonGrid>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonList>
          {chairs?.map((v, k) => {
            return <ChairComponent chair={v} key={k} />;
          })}
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Chairs;
