import style from "./style.module.scss";
import { SearchOutlined } from "@ant-design/icons";

export const SearchBar = (props) => {
  return (
    <div className={style.searchBarBox}>
      <div className={style.searchBarBar} type="search">
        <input {...props} placeholder="Поиск..." />
        <SearchOutlined />{" "}
      </div>
    </div>
  );
};

export default SearchBar;
