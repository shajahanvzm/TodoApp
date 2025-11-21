import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import User from "./components/User";

function App() {
  const name = "Shajahan";
  const age = 25;
  const n1 = 10;
  const n2 = 20;
  const sum = n1 + n2;

  const isLoggedIn = false;

  const items = ["Item 1", "Item 2", "Item 3 "];

  const greeting = ({ name }) => {
    alert(`Hello, ${name}`);
  };

  function handleClick() {
    greeting({ name });
  }

  const header = ({ title }) => <h1>Welcome to the App : {title} </h1>;
  const user = { name: "Shajahan", age: 25, location: "India" };
  return (
    <>
      <Header title="Test App" />
      <User user={user} />

      <Footer title="wwww.codemx.com" />
    </>
  );
}

export default App;
