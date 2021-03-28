import {
  IonContent,
  IonHeader,
  IonItem,
  IonLabel,
  IonList,
  IonPage,
  IonText,
  IonTitle,
  IonToolbar,
  IonInput,
  IonSelectOption,
  IonSelect,
  IonButton,
} from "@ionic/react";

const OrderItem: React.FC = () => {

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Order a Item</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent>
          <IonItem>
            <IonLabel>Item</IonLabel>
            <IonSelect>
                <IonSelectOption value="Chair">Chair</IonSelectOption>
                <IonSelectOption value="Desk">Desk</IonSelectOption>
                <IonSelectOption value="Filing">Filing</IonSelectOption>
                <IonSelectOption value="Lamp">Lamp</IonSelectOption>
            </IonSelect>
          </IonItem>
          <IonItem>
            <IonLabel>Type</IonLabel>
            <IonSelect>
                <IonSelectOption value="chair">Chair</IonSelectOption>
            </IonSelect>
          </IonItem>
          <IonItem>
            <IonButton>Request</IonButton>
          </IonItem>
      </IonContent>
    </IonPage>
  );
};

export default OrderItem;
