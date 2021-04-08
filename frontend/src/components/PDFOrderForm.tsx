import React from "react";
import {
  Document,
  Page,
  Text,
  View,
  StyleSheet,
  PDFViewer,
  PDFDownloadLink,
} from "@react-pdf/renderer";
import { GiOfficeChair } from "react-icons/gi";
import { IonButton } from "@ionic/react";
import { Furniture } from "../interfaces/FurnitureTypes";

const styles = StyleSheet.create({});

const MyDocument = (props: OrderViewProps) => (
  <Document>
    <Page size="Letter">
      <View>
        <Text>Furniture Order Form</Text>
      </View>
      <View>
        <Text>Faculty Name: {props.faculty}</Text>
        <Text>Contact: {props.contact}</Text>
        <Text>Date: {new Date().toDateString()}</Text>
      </View>
      <View>
        <Text>
          Original Request: {props.orderedType} {props.orderedItem},{" "}
          {props.orderedQuantity}
        </Text>
      </View>
      <View>
        <Text>Items ordered:</Text>
        {props.items.map((v, k) => {
          return <Text>ID: {v.id}</Text>;
        })}
      </View>
      <View>
        <Text>Total Price: ${props.price}</Text>
      </View>
    </Page>
  </Document>
);

interface OrderViewProps {
  items: Array<Furniture>;
  orderedItem: string;
  orderedType: string;
  orderedQuantity: number;
  faculty: string;
  contact: string;
  price: number;
}

const OrderView: React.FC<OrderViewProps> = (props: OrderViewProps) => (
  <>
    <PDFDownloadLink
      document={<MyDocument {...props} />}
      fileName="orderForm.pdf"
    >
      <IonButton>Download Order Form</IonButton>
    </PDFDownloadLink>
  </>
);

export default OrderView;
