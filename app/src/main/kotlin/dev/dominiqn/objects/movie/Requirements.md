# 영화 예매 시스템
## 목적
사용자는 영화 예매 시스템을 이용해 쉽고 빠르게 보고 싶은 영화를 예매할 수 있다.

## 요구사항
- 영화
    - 영화에 대한 기본 정보
    - 제목, 상영시간, 가격 정보 등을 가진다.
- 상영
    - 실제로 관객들이 영화를 관람하는 사건
    - 사용자가 실제로 예매하는 대상이며, 사람들은 특정 시간에 상영되는 영화를 관람할 권리를 구매
    - 금액은 할인 조건과 할인 정책을 조합하여 결정된다.
    - 예매를 완료하면 예매 정보가 생성된다.
- 할인 조건
    - 가격의 할인 여부를 결정
    - 종류: 순서조건, 기간조건
        - 순서조건
            - 순서조건이 N이라면, 매일 N번째 상영되는 영화를 예매한 사용자에게 할인 제공
        - 기간조건
            - 상영 시작 시간을 이용해 할인 여부 결정
            - 요일, 시작시간, 종료시간으로 구성
            - 상영 시작 시간이 해당 기간 안에 포함될 경우 요금 할인
    - 다수의 할인 조건을 함께 지정할 수 있음
    - 순서와 기간 조건 종류를 섞는 것도 가능
- 할인 정책
    - 할인 요금을 결정
    - 종류: 금액할인정책, 비율할인정책
        - 금액할인정책
            - 예매 요금에서 일정 금액을 할인
        - 비율할인정책
            - 예매 요금에서 일정 비율의 요금을 할인
    - 영화별로 하나의 할인 정책만 할당할 수 있음
    - 할당하지 않을 수 있으며, 이 경우 영화의 기본 가격이 판매 요금이 됨
- 예매
    - 제목, 상영정보, 인원, 정가, 결제금액 등을 가진다.
