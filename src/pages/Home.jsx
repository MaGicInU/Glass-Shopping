import { useRef } from "react";
import { Banner, CategoryList, Trending } from "../components";

const Home = () => {
  const catRef = useRef(null);
  return (
    <>
      <Banner catRef={catRef} />
      <Trending />
      <CategoryList catRef={catRef} />
    </>
  );
};

export default Home;
