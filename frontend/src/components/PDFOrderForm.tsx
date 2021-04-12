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

/**
 * Stylesheet for the PDF
 * @author Robert Brown
 * @since 2.1
 */
const styles = StyleSheet.create({
  defaultMargin: { marginLeft: 50, marginRight: 50 },
  titleBar: {
    marginLeft: 50,
    marginRight: 50,
    marginTop: 75,
    marginBottom: 40,
  },
  text: { color: "#444444" },
  title: { color: "#444444", fontSize: 50 },
  contactInfo: {
    backgroundColor: "#DEDEDE",
    paddingVertical: 20,
    paddingHorizontal: 20,
  },
  finalPrice: { fontSize: 25, fontWeight: "bold" },
  finalPriceContainer: {
    backgroundColor: "#DEDEDE",
    marginTop: 10,
    paddingVertical: 20,
    paddingHorizontal: 20,
  },
});

/**
 * Template component for the pdf
 * @param props information to be displayed on the order form
 * @returns MyDocument component to be rendered as a PDF
 * @author Ratik Kapoor, Robert Brown
 * @since 2.0
 */
const MyDocument = (props: OrderViewProps) => (
  <Document>
    <Page>
      <View style={styles.titleBar}>
        <Text style={styles.title}>Furniture Order Form</Text>
      </View>
      <View style={[styles.defaultMargin, styles.contactInfo]}>
        <Text style={styles.text}>Faculty Name: {props.faculty}</Text>
        <Text style={styles.text}>Contact: {props.contact}</Text>
        <Text style={styles.text}>Date: {new Date().toDateString()}</Text>
      </View>
      <View style={styles.defaultMargin}>
        <Text style={styles.text}>
          Original Request: {props.orderedType} {props.orderedItem},{" "}
          {props.orderedQuantity}
        </Text>
      </View>
      <View style={styles.defaultMargin}>
        <Text style={styles.text}>Items ordered:</Text>
        {props.items.map((v, k) => {
          return <Text style={styles.text}>ID: {v.id}</Text>;
        })}
      </View>
      <View style={[styles.defaultMargin, styles.finalPriceContainer]}>
        <Text style={[styles.text, styles.finalPrice]}>
          Total Price: ${props.price}
        </Text>
      </View>
    </Page>
  </Document>
);

/**
 * data to pass to the pdf view
 * @author Ratik Kapoor
 */
interface OrderViewProps {
  items: Array<Furniture>;
  orderedItem: string;
  orderedType: string;
  orderedQuantity: number;
  faculty: string;
  contact: string;
  price: number;
}

/**
 * a react component do display the pdf download
 * @param props information to be displayed on the order form
 * @returns a download order form button to be renderd
 * @author Ratik Kapoor, Robert Brown
 */
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
