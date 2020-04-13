export class TableInfo {
  private _actionUrl: string;
  private _header: string[];
  private _data: Object[];
  constructor() {}

  get actionUrl() {
    return this._actionUrl;
  }
  get header() {
    return this._header;
  }
  get data() {
    return this._data;
  }
  set actionUrl(actionUrl: string) {
    this._actionUrl = actionUrl;
  }
  set header(header: string[]) {
    this._header = header;
  }
  set data(data: Object[]) {
    this._data = data;
  }
}
